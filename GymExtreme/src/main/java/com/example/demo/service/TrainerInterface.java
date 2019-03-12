package com.example.demo.service;

import java.util.List;
import com.example.demo.domain.Trainer;
import com.example.demo.domain.dto.TrainerDto;
import com.example.demo.domain.dto.TrainerWorkoutDto;

public interface TrainerInterface {

	public List<Trainer> findAll();
	
	public Trainer findById(Long id);
	
	public Trainer save(TrainerDto trainerDto);
	
	public Trainer update(Trainer trainer);
	
	public String delete(Long id);
	
	public TrainerWorkoutDto workoutList (Long trainer_id);
	
}
