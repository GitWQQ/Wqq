package org.ssm.dufy.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.ssm.dufy.entity.UserInfo;

public class TokenManager {

	/**
	 * 获取当前用户对象
	 * 
	 */
	public static UserInfo getCurrentUser(){
		UserInfo userInfo=(UserInfo)SecurityUtils.getSubject().getPrincipal();
		return userInfo;
	}
	
	/**
	 * 获取当前用户Session
	 * 
	 */
	public static Session getSession(){
		Session session=SecurityUtils.getSubject().getSession();
		return session;
	}
	
	/**
	 * 往当前用户session里设置值	
	 */
	
	public static void setSessionValue(Object sessionId,Object object){
		getSession().setAttribute(sessionId,object);
	}
	/**
	 * 获取session值
	 */
	
	public static Object getSessionValue(Object key){
		return  getSession().getAttribute(key);
	}
	
	/**
	 * 获取验证码后删除
	 */
	public static String getYZM(){
		String yzm=(String)getSession().getAttribute("_CODE");
		//getSession().removeAttribute("_CODE");
		return yzm;
	}
}
