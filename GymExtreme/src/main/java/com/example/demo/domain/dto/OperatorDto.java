package com.example.demo.domain.dto;

public class OperatorDto {
	
	private String name;
	private String surname;
	private String email;
	private String operatorPassword;
	
	public OperatorDto() {
		super();
	}
	
	public OperatorDto(String name, String surname, String email, String operatorPassword) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.operatorPassword = operatorPassword;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
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
		return "OperatorDto [name=" + name + ", surname=" + surname + ", email=" + email + ", operatorPassword="
				+ operatorPassword + "]";
	}
	
}
