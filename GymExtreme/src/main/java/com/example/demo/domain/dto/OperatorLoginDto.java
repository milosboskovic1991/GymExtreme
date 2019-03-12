package com.example.demo.domain.dto;

public class OperatorLoginDto {

	private String email;
	private String operatorPassword;
	
	public OperatorLoginDto(String email, String operatorPassword) {
		super();
		this.email = email;
		this.operatorPassword = operatorPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOperatorPassword() {
		return operatorPassword;
	}

	public void setOperatorPassword(String operatorPassword) {
		this.operatorPassword = operatorPassword;
	}

	@Override
	public String toString() {
		return "OperatorLoginDto [email=" + email + ", operatorPassword=" + operatorPassword + "]";
	}
	
}
