package org.ssm.dufy.entity;

public class UserEntity {
	
	//�û�id
	private String userId;
	
	//�û��˺�
	private String EmpCode;
	
	//�û�����
	private String EmpName;
	
	//�û���ɫ
	private String role;
	
	//ְλ
	private String title;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmpCode() {
		return EmpCode;
	}

	public void setEmpCode(String empCode) {
		EmpCode = empCode;
	}

	public String getEmpName() {
		return EmpName;
	}

	public void setEmpName(String empName) {
		EmpName = empName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "UserEntity [userId=" + userId + ", EmpCode=" + EmpCode + ", EmpName=" + EmpName + ", role=" + role
				+ ", title=" + title + "]";
	}
	
}
