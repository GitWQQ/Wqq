package org.ssm.dufy.entity.shiro;

import java.util.List;
import org.ssm.dufy.entity.UserInfo;

public class SysRole {

	private Integer role_id;//编号
	private String role;//角色标识程序中判断使用，如admin,这个是唯�?�?
	private String description; //角色描述，UI界面显示作用
	private String avaiable;//是否可用，如果不可用则将不会添加用户
	
	//角色--权限关系，多对多关系
	private List<SysPermission> permissions;
	
	// 用户 - 角色关系定义;
	private List<UserInfo> userInfos;// �?个角色对应多个用�?
	
	public Integer getRole_id() {
		return role_id;
	}
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public String getAvaiable() {
		return avaiable;
	}
	public void setAvaiable(String avaiable) {
		this.avaiable = avaiable;
	}
	public List<SysPermission> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<SysPermission> permissions) {
		this.permissions = permissions;
	}

	public List<UserInfo> getUserInfos() {
		return userInfos;
	}

	public void setUserInfos(List<UserInfo> userInfos) {
		this.userInfos = userInfos;
	}
	@Override
	public String toString() {
		return "SysRole [role_id=" + role_id + ", role=" + role + ", description=" + description + ", avaiable="
				+ avaiable + ", permissions=" + permissions + ", userInfos=" + userInfos + "]";
	}
	
}
