package org.ssm.dufy.entity;

import java.io.Serializable;
import java.util.List;

import org.ssm.dufy.entity.shiro.SysRole;

public class UserInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String yh_id;
	private String username;
	private String name;
	private String email;
	private String password;
	private String salt; //加密密码的盐
	private String state;
	private Boolean rememberMe;
	private String vcode;
	//用户状态，0创建未认证（比如没有激活，没有输入验证码等等）
		//等待验证的用户，1:正常状态，2：用户被锁定
	private List<SysRole> roleList;
	
	public String getYh_id() {
		return yh_id;
	}
	public void setYh_id(String yh_id) {
		this.yh_id = yh_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public List<SysRole> getRoleList() {
		return roleList;
	}
	public void setRoleList(List<SysRole> roleList) {
		this.roleList = roleList;
	}
	public Boolean getRememberMe() {
		return rememberMe;
	}
	public void setRememberMe(Boolean rememberMe) {
		this.rememberMe = rememberMe;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getVcode() {
		return vcode;
	}
	public void setVcode(String vcode) {
		this.vcode = vcode;
	}
	
	
	public UserInfo() {
		super();
	}
	public UserInfo(String yh_id, String username, String name, String email, String password, String salt,
			String state, Boolean rememberMe, String vcode) {
		super();
		this.yh_id = yh_id;
		this.username = username;
		this.name = name;
		this.email = email;
		this.password = password;
		this.salt = salt;
		this.state = state;
		this.rememberMe = rememberMe;
		this.vcode = vcode;
	}
	@Override
	public String toString() {
		return "UserInfo [yh_id=" + yh_id + ", username=" + username + ", name=" + name + ", password=" + password
				+ ", salt=" + salt + ", state=" + state + ", rememberMe=" + rememberMe + ", roleList=" + roleList + "]";
	}
}
