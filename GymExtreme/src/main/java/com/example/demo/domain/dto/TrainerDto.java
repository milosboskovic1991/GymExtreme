package com.example.demo.domain.dto;

import java.util.List;
import com.example.demo.domain.Workout;

public class TrainerDto {
	
	private String name;
	private String surname;
	private double price;
	private List<Workout> workouts;
	private int numberOfTrainings;
	
	public TrainerDto() {
		super();
	}
	
	public TrainerDto(String name, String surname, double price) {
		super();
		this.name = name;
		this.surname = surname;
		this.price = price;
	}
	public TrainerDto(String name, String surname, double price, List<Workout> workouts) {
		super();
		this.name = name;
		this.surname = surname;
		this.price = price;
		this.workouts = workouts;
	}
		
	public TrainerDto(String name, String surname, double price, int numberOfTrainings) {
		super();
		this.name = name;
		this.surname = surname;
		this.price = price;
		this.numberOfTrainings = numberOfTrainings;
	}

	public TrainerDto(String name, String surname, double price, List<Workout> workouts, int numberOfTrainings) {
		super();
		this.name = name;
		this.surname = surname;
		this.price = price;
		this.workouts = workouts;
		this.numberOfTrainings = numberOfTrainings;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public List<Workout> getWorkouts() {
		return workouts;
	}
	public void setWorkouts(List<Workout> workouts) {
		this.workouts = workouts;
	}
	
	public int getNumberOfTrainings() {
		return numberOfTrainings;
	}

	public void setNumberOfTrainings(int numberOfTrainings) {
		this.numberOfTrainings = numberOfTrainings;
	}

	@Override
	public String toString() {
		return "TrainerDto [name=" + name + ", surname=" + surname + ", price=" + price + ", workouts=" + workouts
				+ ", numberOfTrainings=" + numberOfTrainings + "]";
	} 
	
}
