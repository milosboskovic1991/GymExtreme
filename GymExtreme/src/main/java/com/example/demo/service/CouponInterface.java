package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.Coupon;
import com.example.demo.domain.dto.CouponDto;

public interface CouponInterface {

	public List<Coupon> findAll();
	
	public Coupon findById(Long id);
	
	public Coupon save(CouponDto couponDto);
	
	public Coupon update(Coupon coupon);
	
	public String delete(Long id);
}
