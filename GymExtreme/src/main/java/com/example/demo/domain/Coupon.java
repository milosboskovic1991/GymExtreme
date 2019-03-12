package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name="coupon")
public class Coupon {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="coupon_type", nullable=false)
	private String couponType;
	
	@Column(name="coupon_discount", nullable=false)
	private double couponDiscount;
	
	public Coupon() {
		super();
	}

	public Coupon(String couponType, double couponDiscount) {
		super();
		this.couponType = couponType;
		this.couponDiscount = couponDiscount;
	}

	public Coupon(Long id, String couponType, double couponDiscount) {
		super();
		this.id = id;
		this.couponType = couponType;
		this.couponDiscount = couponDiscount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCouponType() {
		return couponType;
	}

	public void setCouponType(String couponType) {
		this.couponType = couponType;
	}

	public double getCouponDiscount() {
		return couponDiscount;
	}

	public void setCouponDiscount(double couponDiscount) {
		this.couponDiscount = couponDiscount;
	}



	@Override
	public String toString() {
		return "Coupon [id=" + id + ", couponType=" + couponType + ", couponDiscount=" + couponDiscount + "]";
	}
	
}
