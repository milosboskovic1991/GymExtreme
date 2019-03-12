package com.example.demo.domain.dto;

import java.util.List;

import com.example.demo.domain.Workout;

public class OperatorWorkoutDto {
	
	private Long operator_id;
	private String name;
	private String surname;
	private List<Workout> workouts;
	
	public OperatorWorkoutDto() {
		super();
	}

	public OperatorWorkoutDto(Long operator_id, String name, String surname, List<Workout> workouts) {
		super();
		this.operator_id = operator_id;
		this.name = name;
		this.surname = surname;
		this.workouts = workouts;
	}

	public Long getOperator_id() {
		return operator_id;
	}

	public void setOperator_id(Long operator_id) {
		this.operator_id = operator_id;
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

	public List<Workout> getWorkouts() {
		return workouts;
	}

	public void setWorkouts(List<Workout> workouts) {
		this.workouts = workouts;
	}

	@Override
	public String toString() {
		return "OperatorWorkoutDto [operator_id=" + operator_id + ", name=" + name + ", surname=" + surname
				+ ", workouts=" + workouts + "]";
	}
	
}
