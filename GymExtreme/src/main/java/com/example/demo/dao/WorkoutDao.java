package com.example.demo.dao;

import java.util.Date;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Member;
import com.example.demo.domain.Operator;
import com.example.demo.domain.Trainer;
import com.example.demo.domain.Workout;

@Repository
public interface WorkoutDao extends CrudRepository<Workout, Long>{
	
	List<Workout> findByMember(Member member);
	List<Workout> findByTrainer(Trainer trainer);
	List<Workout> findByDateWorkoutBetween(Date start_date, Date end_date);
	List<Workout> findByOperator(Operator operator);	

}
