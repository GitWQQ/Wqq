package org.ssm.dufy.web.common;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.ssm.dufy.util.LoggerUtils;
import org.ssm.dufy.util.TokenManager;
import org.ssm.dufy.util.verifyCodeUtils.VerifyCodeUtils;
import org.ssm.dufy.util.verifyCodeUtils.vcode.Captcha;
import org.ssm.dufy.util.verifyCodeUtils.vcode.GifCaptcha;
import org.ssm.dufy.util.verifyCodeUtils.vcode.SpecCaptcha;


@Controller
@RequestMapping("/check")
public class CommonController {

	@RequestMapping(value="getVCode.shtml",method=RequestMethod.GET)
	public void getVCode(HttpServletRequest request,HttpServletResponse response){
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires",0);
		response.setContentType("image/jpg");
		
	   //生成随机字串  
		String verifyCode=VerifyCodeUtils.generateVerifyCode(4);
		//存入到Session
		TokenManager.setSessionValue(VerifyCodeUtils.V_CODE,verifyCode);
		//生成图片  
		int w = 146, h = 33;  
		try {
			VerifyCodeUtils.outputImage(w, h,response.getOutputStream(),verifyCode);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			LoggerUtils.fmtError(getClass(),e, "获取验证码异常：%s",e.getMessage());
		}
	}
	
	
	/**
	 * 获取验证码（Gif版本）
	 * @param response
	 */
	@RequestMapping(value="getGifCode.shtml",method=RequestMethod.GET)
	public void getGifCode(HttpServletResponse response,HttpServletRequest request){
		 try {
			 response.setHeader("Pragma", "No-cache");  
			 response.setHeader("Cache-Control", "no-cache");  
			 response.setDateHeader("Expires", 0);  
			 response.setContentType("image/gif");  
			 /**
			  * gif格式动画验证码
			  * 	宽，高，位数。
			  */
			 Captcha captcha = new GifCaptcha(146,42,4);
			 ServletOutputStream out=response.getOutputStream();
			 captcha.out(out);
			 out.flush();
			 //存入Shiro会话session  
	         TokenManager.setSessionValue(VerifyCodeUtils.V_CODE, captcha.text().toLowerCase());
		 } catch (IOException e) {
			e.printStackTrace();
			LoggerUtils.fmtError(getClass(),e, "获取验证码异常：%s",e.getMessage());
		}
	}
	
	/**
	 * 获取验证码（jpg版本）
	 * @param response
	 */
	@RequestMapping(value="getJPGCode.shtml",method=RequestMethod.GET)
	public void getJPGCode(HttpServletResponse response,HttpServletRequest request){
		try {
			response.setHeader("Pragma", "No-cache");  
			response.setHeader("Cache-Control", "no-cache");  
			response.setDateHeader("Expires", 0);  
			response.setContentType("image/jpg");  
			/**
			 * jgp格式验证码
			 * 宽，高，位数。
			 */
			Captcha captcha = new SpecCaptcha(146,33,4);
			//输出
			captcha.out(response.getOutputStream());
			HttpSession session = request.getSession(true);  
			//存入Session
			session.setAttribute("_code",captcha.text().toLowerCase());  
		} catch (Exception e) {
			LoggerUtils.fmtError(getClass(),e, "获取验证码异常：%s",e.getMessage());
		}
	}
	
}
