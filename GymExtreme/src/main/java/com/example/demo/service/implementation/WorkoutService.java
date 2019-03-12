package com.example.demo.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.MemberDao;
import com.example.demo.dao.OperatorDao;
import com.example.demo.dao.TrainerDao;
import com.example.demo.dao.WorkoutDao;
import com.example.demo.domain.Member;
import com.example.demo.domain.Operator;
import com.example.demo.domain.Trainer;
import com.example.demo.domain.Workout;
import com.example.demo.domain.dto.IntervalDto;
import com.example.demo.domain.dto.WorkoutDto;
import com.example.demo.service.WorkoutInterface;

@Service
public class WorkoutService implements WorkoutInterface {

	TrainerDao trainerDao;
	MemberDao memberDao;
	WorkoutDao workoutDao;
	OperatorDao operatorDao;
	TrainerService trainerService;

	
	@Autowired
	public WorkoutService(TrainerDao trainerDao, MemberDao memberDao, WorkoutDao workoutDao, OperatorDao operatorDao,
			TrainerService trainerService) {
		super();
		this.trainerDao = trainerDao;
		this.memberDao = memberDao;
		this.workoutDao = workoutDao;
		this.operatorDao = operatorDao;
		this.trainerService = trainerService;
	}

	//Showing all Workouts
	@Override
	public List<Workout> findAll() {
		return (List<Workout>) workoutDao.findAll();
	}

	//Finding specific Workout by Id
	@Override
	public Workout findById(Long id) {
		Optional<Workout> optionalWorkout = workoutDao.findById(id);
		if(optionalWorkout.isPresent()) {
			return optionalWorkout.get();
		}
		return null;
	}

	//Adding new Workout with price which depends of if member has a coupon or not
	@Override
	@Transactional
	public String save(WorkoutDto workoutDto) {
		Optional<Member> optionalMember = memberDao.findById(workoutDto.getMember_id());
		Optional<Operator> optionalOperator = operatorDao.findById(workoutDto.getOperator_id());
		if(optionalMember.isPresent() && optionalOperator.isPresent()) {
			Member member = optionalMember.get();
			Operator operator = optionalOperator.get();
			Workout workout = new Workout();
			workout.setDateWorkout(workoutDto.getDateWorkout());
			workout.setStartTime(workoutDto.getStartTime());
			workout.setEndTime(workoutDto.getEndTime());
			workout.setMember(member);
			workout.setOperator(operator);
			
			if(member.getSubscription().getSubType().equals("Daily") && workoutDto.getTrainer_id()!=null) { // First-case (Daily, Trainer exist)
				Optional<Trainer> optionalTrainer = trainerDao.findById(workoutDto.getTrainer_id());
				Trainer trainer = optionalTrainer.get();
				trainer.setNumberOfTrainings(trainer.getNumberOfTrainings()+1);
				if(member.getCoupon()!=null) {
					workout.setPrice(member.getSubscription().getPrice()*member.getCoupon().getCouponDiscount()+trainer.getPrice()*member.getCoupon().getCouponDiscount());
					workout.setTrainer(trainer);
					workoutDao.save(workout);
				}else {
					workout.setPrice(member.getSubscription().getPrice()+trainer.getPrice());
					workout.setTrainer(trainer);
					workoutDao.save(workout);
				}
								
				//update trainer's price after every 10 trainings 
				if(trainer.getNumberOfTrainings()%10==0) {
					double priceNow = trainer.getPrice();
					trainer.setPrice(priceNow*0.10+priceNow);
					trainerService.update(trainer);
				}			
			}
			
			else if(member.getSubscription().getSubType().equals("Daily") && workoutDto.getTrainer_id()==null){ // Second-case (Daily, Trainer null)
				if(member.getCoupon()!=null) {
					workout.setPrice(member.getSubscription().getPrice()*member.getCoupon().getCouponDiscount());
					workoutDao.save(workout);
				}else {
					workout.setPrice(member.getSubscription().getPrice());
					workoutDao.save(workout);
				}	
			}
			
			else if(member.getSubscription().getSubType().equals("Monthly") && workoutDto.getTrainer_id()!=null) { // Third-case (Monthly, Trainer exist)
				Optional<Trainer> optionalTrainer = trainerDao.findById(workoutDto.getTrainer_id());
				Trainer trainer = optionalTrainer.get();
				trainer.setNumberOfTrainings(trainer.getNumberOfTrainings()+1);
				if(member.getCoupon()!=null) {
					workout.setPrice(trainer.getPrice()*member.getCoupon().getCouponDiscount());
					workout.setTrainer(trainer);
					workoutDao.save(workout);
				}else {
					workout.setPrice(trainer.getPrice());
					workout.setTrainer(trainer);
					workoutDao.save(workout);
					
				}
				
				//update trainer's price after every 10 trainings 
				if(trainer.getNumberOfTrainings()%10==0) {	
					double priceNow = trainer.getPrice();
					trainer.setPrice(priceNow*0.10+priceNow);
					trainerService.update(trainer);
				}				
			}
				
			else { // Fourth-case (Monthly, Trainer null)
				workout.setPrice(0.0);
				workoutDao.save(workout);
			}	
		}
		if(optionalMember.isPresent()) {
			return "Workout saved!!!";
		}
		return "Unknown member_id!!!";
	}

	//Deleting existing Workout
	@Override
	public String delete(Long id) {
		workoutDao.deleteById(id);
		return "Object deleted!!!";
	}

	//Showing all workouts in some interval
	@Override
	@Transactional
	public List<Workout> search(IntervalDto intervalDto) {	
		return workoutDao.findByDateWorkoutBetween(intervalDto.getDate_from(), intervalDto.getDate_to());
	}

}
