package org.ssm.dufy.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.ssm.dufy.entity.UserInfo;
import org.ssm.dufy.util.shiro.UserInfoLoginToken;

public class LoginInter {
		
	private static final Logger log=LoggerFactory.getLogger(LoginInter.class);

	public static Map<String,Object> doLogin(Object object){
		UserInfo userInfo=(UserInfo)object;
		Map<String,Object> result=new HashMap<String,Object>();
		String userName=userInfo.getUsername().trim();
		String passWord=userInfo.getPassword().trim();
		boolean rememberMe=userInfo.getRememberMe();
		Subject subject=SecurityUtils.getSubject();
		UserInfoLoginToken token=null;
		if(userName!=null && !"".equals(userName)){
					new UserInfoLoginToken(userName, passWord, rememberMe, userInfo);
		}
		try{//登录
			subject.login(token);
		}catch(UnknownAccountException uae){
			log.error("用户不存在");
			result.put("status",201);
			result.put("message","用户不存在");
		}catch(IncorrectCredentialsException ice){
			log.error("密码不正确");
			result.put("status",202);
			result.put("message","密码不正确");
		}catch(LockedAccountException lae){
			log.error("账号被锁定");
			result.put("status",203);
			result.put("message","账号被锁定");
		}catch(ExcessiveAttemptsException eae){
			log.error("密码尝试限制");
			result.put("status",204);
			result.put("message","密码尝试限制");
		}
		return result;	
	}
}
