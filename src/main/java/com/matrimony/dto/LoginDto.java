package com.matrimony.dto;

public class LoginDto {
	private String loginName;
	private String password;
	private String actionMessage;

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPasasword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginDto [loginName=" + loginName + ", password=" + password + ", actionMessage=" + actionMessage + "]";
	}

}
