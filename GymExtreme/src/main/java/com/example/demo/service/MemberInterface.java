package com.example.demo.service;

import java.util.List;
import com.example.demo.domain.Member;
import com.example.demo.domain.dto.MemberDto;
import com.example.demo.domain.dto.MemberWorkoutDto;

public interface MemberInterface {

	public List<Member> findAll();
	
	public Member findById(Long id);
	
	public Member save(MemberDto memberDto);
	
	public Member update(Member member);
	
	public String delete(Long id);
	
	public MemberWorkoutDto workoutList(Long member_id);
	
	public boolean validationEmail(String email);
	
	
}
