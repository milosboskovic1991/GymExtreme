package com.example.demo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.MemberDao;
import com.example.demo.domain.Member;
import com.example.demo.domain.dto.MemberDto;
import com.example.demo.domain.dto.MemberWorkoutDto;
import com.example.demo.service.implementation.MemberService;

@RestController
@RequestMapping("/member")
public class MemberController {

	@Autowired
	MemberDao memberDao;
	
	@Autowired
	MemberService memberService;
	
	//Showing all Members
	@RequestMapping(value="/findAll", method=RequestMethod.GET)
	public List<Member> findAll(){
		return memberService.findAll();
	}
	
	//Finding specific Member by Id
	@RequestMapping("/find/{id}")
	public Member getMember(@PathVariable Long id){
		return memberService.findById(id);
		
	}
	
	//Adding new Member
	@RequestMapping(value = "/save", method=RequestMethod.POST)
	public @ResponseBody Member save(@RequestBody MemberDto memberDto) {
		return memberService.save(memberDto);
	}
	
	//Updating existing Member
	@PutMapping(value = "/update")
	public Member update(@RequestBody Member member) {
		memberService.update(member);
		return member;
	}
	
	//Deleting existing Member
	@DeleteMapping(value = "/delete")
	public String delete(@RequestParam Long id) {
		return memberService.delete(id);
	}
	
	//Showing all workouts for specific Member by Id
	@RequestMapping(value="workoutList/{member_id}")
	public MemberWorkoutDto workoutList(@PathVariable Long member_id) {
		return memberService.workoutList(member_id);	
	}
}
