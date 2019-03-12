package com.example.demo.domain.dto;

import java.util.List;
import com.example.demo.domain.Workout;

public class MemberWorkoutDto {
	
	private Long member_id;
	private String name;
	private String surname;
	private String subType;
	private List<Workout> workouts;
	
	public MemberWorkoutDto() {
		super();
	}

	public MemberWorkoutDto(Long member_id, String name, String surname, String subType, String couponType,
			List<Workout> workouts) {
		super();
		this.member_id = member_id;
		this.name = name;
		this.surname = surname;
		this.subType = subType;
		this.workouts = workouts;
	}

	public Long getMember_id() {
		return member_id;
	}

	public void setMember_id(Long member_id) {
		this.member_id = member_id;
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

	public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	public List<Workout> getWorkouts() {
		return workouts;
	}

	public void setWorkouts(List<Workout> workouts) {
		this.workouts = workouts;
	}

	@Override
	public String toString() {
		return "MemberWorkoutDto [member_id=" + member_id + ", name=" + name + ", surname=" + surname + ", subType="
				+ subType  + ", workouts=" + workouts + "]";
	}

}
