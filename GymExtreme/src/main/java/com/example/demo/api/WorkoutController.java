package com.example.demo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.WorkoutDao;
import com.example.demo.domain.Workout;
import com.example.demo.domain.dto.IntervalDto;
import com.example.demo.domain.dto.WorkoutDto;
import com.example.demo.service.implementation.WorkoutService;

@RestController
@RequestMapping("/workout")
public class WorkoutController {

	@Autowired
	WorkoutDao workoutDao;
	
	@Autowired
	WorkoutService workoutService;
	
	//Showing all Workouts
	@RequestMapping(value="/findAll", method=RequestMethod.GET)
	public List<Workout> findAll(){
		return workoutService.findAll();
	}
	
	//Finding specific Workout by Id
	@RequestMapping("/find/{id}")
	public Workout getWorkout(@PathVariable Long id){
		return workoutService.findById(id);
		
	}
	
	//Adding new Workout
	@RequestMapping(value = "/save", method=RequestMethod.POST)
	public @ResponseBody String save(@RequestBody WorkoutDto workoutDto) {
		return workoutService.save(workoutDto);
	}
	
	//Deleting existing Workout
	@DeleteMapping(value = "/delete")
	public String delete(@RequestParam Long id) {
		return workoutService.delete(id);
	}
	
	//Showing all workouts in some interval
	@GetMapping(value="/findByInterval")
	public List<Workout> showInterval(@RequestBody IntervalDto intervalDto){
		return workoutService.search(intervalDto);
	}
}
