package org.ssm.dufy.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.ssm.dufy.entity.UserInfo;

public class TokenManager {

	/**
	 * ��ȡ��ǰ�û�����
	 * 
	 */
	public static UserInfo getCurrentUser(){
		UserInfo userInfo=(UserInfo)SecurityUtils.getSubject().getPrincipal();
		return userInfo;
	}
	
	/**
	 * ��ȡ��ǰ�û�Session
	 * 
	 */
	public static Session getSession(){
		Session session=SecurityUtils.getSubject().getSession();
		return session;
	}
	
	/**
	 * ����ǰ�û�session������ֵ	
	 */
	
	public static void setSessionValue(Object sessionId,Object object){
		getSession().setAttribute(sessionId,object);
	}
	/**
	 * ��ȡsessionֵ
	 */
	
	public static Object getSessionValue(Object key){
		return  getSession().getAttribute(key);
	}
	
	/**
	 * ��ȡ��֤���ɾ��
	 */
	public static String getYZM(){
		String yzm=(String)getSession().getAttribute("_CODE");
		//getSession().removeAttribute("_CODE");
		return yzm;
	}
}
