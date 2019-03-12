package com.example.demo.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Component
@Entity
@Table(name="member")
public class Member {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name", nullable=false)
	private String name;
	
	@Column(name="surname", nullable=false)
	private String surname;
	
	@Column(name="email", nullable=false, unique=true)
	private String email;
	
	@ManyToOne(targetEntity=Subscription.class)
	@JoinColumn(name="subscription_id", foreignKey=@ForeignKey(name="fk_subscription"))
	private Subscription subscription;
	
	@ManyToOne(targetEntity=Coupon.class)
	@JoinColumn(name="coupon_id", foreignKey=@ForeignKey(name="fk_coupon"))
	private Coupon coupon;
		
	@OneToMany(targetEntity=Workout.class,mappedBy="member", fetch = FetchType.EAGER)
	@JsonBackReference //prevents recursion
	private List<Workout> workouts = new ArrayList<Workout>();

	public Member() {
		super();
	}
	
	public Member(Long id, String name, String surname, String email, Subscription subscription, Coupon coupon) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.subscription = subscription;
		this.coupon = coupon;
	}

	public Member(String name, String surname, String email, Subscription subscription, Coupon coupon) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.subscription = subscription;
		this.coupon = coupon;
	}

	public Member(String name, String surname, String email, Subscription subscription, Coupon coupon,
			List<Workout> workouts) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.subscription = subscription;
		this.coupon = coupon;
		this.workouts = workouts;
	}

	public Member(String name, String surname, String email, Subscription subscription, List<Workout> workouts) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.subscription = subscription;
		this.workouts = workouts;
	}

	public Member(Long id, String name, String surname, String email, Subscription subscription, Coupon coupon,
			List<Workout> workouts) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.subscription = subscription;
		this.coupon = coupon;
		this.workouts = workouts;
	}

	public Member(Long id, String name, String surname, String email, Subscription subscription,
			List<Workout> workouts) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.subscription = subscription;
		this.workouts = workouts;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<Workout> getWorkouts() {
		return workouts;
	}

	public void setWorkouts(List<Workout> workouts) {
		this.workouts = workouts;
	}

	public Coupon getCoupon() {
		return coupon;
	}

	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", surname=" + surname + ", email=" + email + ", subscription="
				+ subscription + ", coupon=" + coupon + ", workouts=" + workouts + "]";
	}

}
