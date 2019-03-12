package com.example.demo.domain.dto;

public class CouponDto {
	
	private String couponType;
	
	private double couponDiscount;

	public CouponDto(String couponType, double couponDiscount) {
		super();
		this.couponType = couponType;
		this.couponDiscount = couponDiscount;
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
		return "CouponDto [couponType=" + couponType + ", couponDiscount=" + couponDiscount + "]";
	}

	
	
}
