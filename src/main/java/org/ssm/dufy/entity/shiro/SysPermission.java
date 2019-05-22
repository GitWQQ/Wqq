package org.ssm.dufy.entity.shiro;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.type.JdbcType;

public class SysPermission implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer permission_id; //主键
	private String name;//名称
	private String resourceType;//资源类型，[menu|button]
	private String url;//资源路径
	private String permission;
	//权限字符串，menu例子：role:*,
	//button：例子：role:create,role:update,role:delete,role:view
	private Long parentId;//父编号
	private String parentIds;//父编号列
	private String avaiable;
	
	private List<SysRole> roles;

	
	public Integer getPermission_id() {
		return permission_id;
	}

	public void setPermission_id(Integer permission_id) {
		this.permission_id = permission_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getParentIds() {
		return parentIds;
	}

	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}

	public List<SysRole> getRoles() {
		return roles;
	}

	public void setRoles(List<SysRole> roles) {
		this.roles = roles;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "SysPermission [permission_id=" + permission_id + ", name=" + name + ", resourceType=" + resourceType
				+ ", url=" + url + ", permission=" + permission + ", parentId=" + parentId + ", parentIds=" + parentIds
				+ ", avaiable=" + avaiable + ", roles=" + roles + "]";
	}
		
}
