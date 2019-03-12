package com.example.demo.domain.dto;

import com.example.demo.domain.Coupon;
import com.example.demo.domain.Subscription;


public class MemberDto {
	
	private String name;
	private String surname;
	private String email;
	private Subscription subscription;
	private Coupon coupon;
		
	public MemberDto() {
		super();
	}
	
	public MemberDto(String name, String surname, String email, Subscription subscription, Coupon coupon) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.subscription = subscription;
		this.coupon = coupon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Subscription getSubscription() {
		return subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}

	public Coupon getCoupon() {
		return coupon;
	}

	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
	}

	@Override
	public String toString() {
		return "MemberDto [name=" + name + ", surname=" + surname + ", email=" + email + ", subscription="
				+ subscription + ", coupon=" + coupon + "]";
	}

}
