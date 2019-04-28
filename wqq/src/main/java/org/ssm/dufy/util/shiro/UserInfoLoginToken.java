package org.ssm.dufy.util.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;
import org.ssm.dufy.entity.UserInfo;

public class UserInfoLoginToken extends UsernamePasswordToken{
	
	private static final long serialVersionUID = 1L;
	private UserInfo userInfo;

	public UserInfoLoginToken(String username,String password,UserInfo userInfo) {
		super(username,password);
		this.userInfo = userInfo;
	}
	
	public UserInfoLoginToken(String username,char[] password,
			boolean rememberMe,String host,UserInfo userInfo){
		super(username,password,rememberMe,host);
		this.userInfo=userInfo;
	}
	
	public UserInfoLoginToken(String username,String password,boolean rememberMe,UserInfo userInfo) {
		super(username,password,rememberMe);
		this.userInfo=userInfo;
	}

	public UserInfoLoginToken(String username ,String password,boolean rememberMe,
			String host,UserInfo userInfo){
		super(username,password,rememberMe,host);
		this.userInfo=userInfo;
	}
	
	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
}
