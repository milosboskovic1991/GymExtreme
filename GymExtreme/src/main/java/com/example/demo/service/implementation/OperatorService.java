package com.example.demo.service.implementation;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.OperatorDao;
import com.example.demo.dao.WorkoutDao;
import com.example.demo.domain.Operator;
import com.example.demo.domain.Workout;
import com.example.demo.domain.dto.OperatorDto;
import com.example.demo.domain.dto.OperatorWorkoutDto;
import com.example.demo.service.OperatorInterface;

@Service
public class OperatorService implements OperatorInterface {

	OperatorDao operatorDao;
	WorkoutDao workoutDao;
	
	@Autowired
	public OperatorService(OperatorDao operatorDao, WorkoutDao workoutDao) {
		super();
		this.operatorDao = operatorDao;
		this.workoutDao = workoutDao;
	}
	
	//Showing all Operators
	@Override
	public List<Operator> findAll() {
		return (List<Operator>) operatorDao.findAll();
	}
	
	//Adding new Operator
	@Override
	public Operator save(OperatorDto operatorDto) {
		Operator operator = new Operator();
		operator.setName(operatorDto.getName());
		operator.setSurname(operatorDto.getSurname());
		operator.setEmail(operatorDto.getEmail());
		if(validationEmail(operatorDto.getEmail())) { //Email validation 
			if(validationPassword(operatorDto.getOperatorPassword())) { //Password validation  
				operator.setOperatorPassword(operatorDto.getOperatorPassword());
				
			}else {
				throw new IllegalArgumentException("It must be between 8 and 10 characters, contain at least one digit and one alphabetic character, "
						+ "and must not contain special characters");
			}
		}else {
			throw new IllegalArgumentException("You entered an email in the wrong format");
		}
		return operator;
	}

	//Deleting existing Operator
	@Override
	public String delete(Long id) {	
		 operatorDao.deleteById(id);
		 return "Operator deleted!!!";
	}
	
	//Showing all entered workouts by specific Operator by Id
	@Override
	public OperatorWorkoutDto workoutList(Long operator_id) {
		Optional<Operator> optionalOperator = operatorDao.findById(operator_id);
		if(optionalOperator.isPresent()) {
			Operator operator = optionalOperator.get();
			List<Workout> workouts = workoutDao.findByOperator(operator);
			OperatorWorkoutDto operatorWorkout = new OperatorWorkoutDto();
			operatorWorkout.setOperator_id(operator.getId());
			operatorWorkout.setName(operator.getName());
			operatorWorkout.setSurname(operator.getSurname());
			operatorWorkout.setWorkouts(workouts);
			return operatorWorkout;
		}
		return null;
	}

	//Helper function for e-mail validation with desired pattern
	@Override
	public boolean validationEmail(String email) {
		String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
		Pattern emailPattern = Pattern.compile(emailRegex,Pattern.CASE_INSENSITIVE);
		Matcher matcher = emailPattern.matcher(email);
		return matcher.find();
	}

	//Helper function for password validation with desired pattern
	@Override
	public boolean validationPassword(String password) {
		String emailRegex = "(?!^[0-9]*$)(?!^[a-zA-Z]*$)^([a-zA-Z0-9]{8,10})$";
		Pattern emailPattern = Pattern.compile(emailRegex,Pattern.CASE_INSENSITIVE);
		Matcher matcher = emailPattern.matcher(password);
		boolean match = matcher.find();
		if(password.length()>=8 && match) {
			return true;
		}
		return false;
	}

}
