package com.example.demo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.OperatorDao;
import com.example.demo.domain.Operator;
import com.example.demo.domain.dto.OperatorDto;
import com.example.demo.domain.dto.OperatorLoginDto;
import com.example.demo.domain.dto.OperatorWorkoutDto;
import com.example.demo.security.LoginService;
import com.example.demo.service.implementation.OperatorService;

@RestController
@RequestMapping("/operator")
public class OperatorController {

	@Autowired
	OperatorDao operatorDao;
	
	@Autowired
	OperatorService operatorService;
	
	@Autowired
	LoginService loginService;
	
	//Showing all Operators
	@RequestMapping(value="/findAll", method=RequestMethod.GET)
	public List<Operator> findAll(){
		return operatorService.findAll();
	}
	
	//Adding new Operator
	@RequestMapping(value = "/save", method=RequestMethod.POST)
	public @ResponseBody Operator save(@RequestBody OperatorDto operatorDto) {
		return operatorService.save(operatorDto);
	}
	
	//Deleting existing Operator
	@DeleteMapping(value = "/delete")
	public String delete(@RequestParam Long id) {
		return operatorService.delete(id);
	}
	
	//Showing all entered workouts by specific Operator by Id
	@RequestMapping(value="/workoutList/{operator_id}")
	public OperatorWorkoutDto workoutList(@PathVariable Long operator_id) {
		return operatorService.workoutList(operator_id);	
	}
	
	//Login method with token authorization
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String operatorLogin(@RequestBody OperatorLoginDto operatorLoginDto) {
		String token =  loginService.authorize(operatorLoginDto);
		return token;	
	}
}
