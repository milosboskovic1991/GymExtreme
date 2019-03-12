package com.example.demo.domain.dto;

import java.util.List;
import com.example.demo.domain.Trainer;
import com.example.demo.domain.Workout;

public class TrainerWorkoutDto {

	private Trainer trainer;
	private List<Workout> workouts;
	
	public TrainerWorkoutDto() {
		super();
	}

	public TrainerWorkoutDto(Trainer trainer, List<Workout> workouts) {
		super();
		this.trainer = trainer;
		this.workouts = workouts;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	public List<Workout> getWorkouts() {
		return workouts;
	}

	public void setWorkouts(List<Workout> workouts) {
		this.workouts = workouts;
	}

	@Override
	public String toString() {
		return "TrainerWorkoutDto [trainer=" + trainer + ", workouts=" + workouts + "]";
	}
	
}
