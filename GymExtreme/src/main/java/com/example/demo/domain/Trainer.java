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
@Table(name="trainer")
public class Trainer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long id;
	
	@Column(name="name", nullable=false)
	public String name;
	
	@Column(name="surname", nullable=false)
	public String surname;
	
	@Column(name="price", nullable=false)
	public double price;
	
	@Column(name="numberOfTrainings", nullable=true)
	public int numberOfTrainings = 0;
	
	@OneToMany(targetEntity=Workout.class,mappedBy="trainer")
	@JsonBackReference //prevents recursion
	private List<Workout> workouts = new ArrayList<Workout>();

	public Trainer() {
		super();
	}
	
	public Trainer(Long id, String name, String surname, double price, int numberOfTrainings) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.price = price;
		this.numberOfTrainings = numberOfTrainings;
	}

	public Trainer(Long id, String name, String surname, double price, List<Workout> workouts) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.price = price;
		this.workouts = workouts;
	}

	public Trainer(Long id, String name, String surname, double price) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.price = price;
	}

	public Trainer(Long id, String name, String surname, double price, int numberOfTrainings, List<Workout> workouts) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.price = price;
		this.numberOfTrainings = numberOfTrainings;
		this.workouts = workouts;
	}

	public Trainer(String name, String surname, double price, int numberOfTrainings, List<Workout> workouts) {
		super();
		this.name = name;
		this.surname = surname;
		this.price = price;
		this.numberOfTrainings = numberOfTrainings;
		this.workouts = workouts;
	}

	public Trainer(String name, String surname, double price, int numberOfTrainings) {
		super();
		this.name = name;
		this.surname = surname;
		this.price = price;
		this.numberOfTrainings = numberOfTrainings;
	}

	public Trainer(String name, String surname, double price) {
		super();
		this.name = name;
		this.surname = surname;
		this.price = price;
	}

	public Trainer(String name, String surname, double price, List<Workout> workouts) {
		super();
		this.name = name;
		this.surname = surname;
		this.price = price;
		this.workouts = workouts;
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
		return "Trainer [id=" + id + ", name=" + name + ", surname=" + surname + ", price=" + price
				+ ", numberOfTrainings=" + numberOfTrainings + ", workouts=" + workouts + "]";
	}
	
}
