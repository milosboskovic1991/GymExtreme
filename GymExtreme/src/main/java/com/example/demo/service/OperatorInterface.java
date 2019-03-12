package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.Operator;
import com.example.demo.domain.dto.OperatorDto;
import com.example.demo.domain.dto.OperatorWorkoutDto;

public interface OperatorInterface {

	public List<Operator> findAll();
	
	public Operator save(OperatorDto operatorDto);
	
	public String delete(Long id);
	
	public OperatorWorkoutDto workoutList(Long operator_id);
	
	public boolean validationEmail(String email);
	
	public boolean validationPassword(String password);
}
