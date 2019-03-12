package com.example.demo.service.implementation;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.CouponDao;
import com.example.demo.dao.MemberDao;
import com.example.demo.dao.WorkoutDao;
import com.example.demo.domain.Member;
import com.example.demo.domain.Workout;
import com.example.demo.domain.dto.MemberDto;
import com.example.demo.domain.dto.MemberWorkoutDto;
import com.example.demo.service.MemberInterface;

@Service
public class MemberService implements MemberInterface{
	
	MemberDao memberDao;
	WorkoutDao workoutDao;

	
	@Autowired
	public MemberService(MemberDao memberDao, WorkoutDao workoutDao, CouponDao couponDao) {
		super();
		this.memberDao = memberDao;
		this.workoutDao = workoutDao;
	}
	
	public MemberDao getMemberDao() {
		return memberDao;
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public WorkoutDao getWorkoutDao() {
		return workoutDao;
	}

	public void setWorkoutDao(WorkoutDao workoutDao) {
		this.workoutDao = workoutDao;
	}
	
	//Showing all Members
	@Override
	public List<Member> findAll() {	
		return (List<Member>) memberDao.findAll();
	}

	//Finding specific Member by Id
	@Override
	public Member findById(Long id) {
		Optional<Member> optionalMember = memberDao.findById(id);
		if(optionalMember.isPresent()) {
			return optionalMember.get();
		}
		return null;
	}

	//Adding new Member
	@Override
	public Member save(MemberDto memberDto) {
		Member member=new Member();
		member.setName(memberDto.getName());
		member.setSurname(memberDto.getSurname());
		member.setEmail(memberDto.getEmail());
		member.setSubscription(memberDto.getSubscription());
		if(memberDto.getCoupon() != null) {
			member.setCoupon(memberDto.getCoupon());
		}	
		if(validationEmail(memberDto.getEmail())) { //Email validation
			memberDao.save(member);			
		}else {
			throw new IllegalArgumentException("You entered an email in the wrong format");
		}	
		return member;
	}

	//Updating existing Member
	@Override
	public Member update(Member member) {	
		return memberDao.save(member);
	}
	
	//Deleting existing Member
	@Override
	public String delete(Long id) {
		memberDao.deleteById(id);
		return "Object deleted!!!";
	}

	//Showing all workouts for specific Member by Id
	@Override
	@Transactional
	public MemberWorkoutDto workoutList(Long member_id) {
		Optional<Member> optionalMember = memberDao.findById(member_id);
		if(optionalMember.isPresent()) {
			Member member = optionalMember.get();
			List<Workout> workouts = workoutDao.findByMember(member);
			MemberWorkoutDto memberWorkout = new MemberWorkoutDto();
			memberWorkout.setMember_id(member.getId());
			memberWorkout.setName(member.getName());
			memberWorkout.setSurname(member.getSurname());
			memberWorkout.setSubType(member.getSubscription().getSubType());
			memberWorkout.setWorkouts(workouts);
			return memberWorkout;
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

}
