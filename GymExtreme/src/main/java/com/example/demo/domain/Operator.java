package com.example.demo.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="operator")
public class Operator {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name", nullable=false)
	private String name;
	
	@Column(name="surname", nullable=false)
	private String surname;
	
	@Column(name="email", nullable=false, unique=true)
	private String email;

	@Column(name="operator_password", nullable = false)
	//@ColumnTransformer(write="encrypt(?)",read="decrypt(operatorPassword)" )
	private String operatorPassword;
	
	@OneToMany(targetEntity=Workout.class,mappedBy="operator")
	@JsonBackReference //prevents recursion
	private List<Workout> workouts = new ArrayList<Workout>();

	public Operator() {
		super();
	}
	
	public Operator(String email, String operatorPassword) {
		super();
		this.email = email;
		this.operatorPassword = operatorPassword;
	}

	public Operator(String name, String surname, String email, String operatorPassword) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.operatorPassword = operatorPassword;
	}

	public Operator(Long id, String name, String surname, String email, String operatorPassword) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.operatorPassword = operatorPassword;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		return "Operator [id=" + id + ", name=" + name + ", surname=" + surname + ", email=" + email
				+ ", operatorPassword=" + operatorPassword + "]";
	}
	
}
