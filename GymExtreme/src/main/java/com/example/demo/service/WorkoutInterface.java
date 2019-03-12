package com.example.demo.service;

import java.util.List;
import com.example.demo.domain.Workout;
import com.example.demo.domain.dto.IntervalDto;
import com.example.demo.domain.dto.WorkoutDto;

public interface WorkoutInterface {

	public List<Workout> findAll();
	
	public Workout findById(Long id);
	
	public String save(WorkoutDto workoutDto);
	
	public String delete(Long id);
	
	public List<Workout> search(IntervalDto intervalDto);
	
}
