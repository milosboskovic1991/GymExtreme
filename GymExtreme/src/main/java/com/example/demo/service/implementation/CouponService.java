package com.example.demo.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CouponDao;
import com.example.demo.domain.Coupon;
import com.example.demo.domain.dto.CouponDto;
import com.example.demo.service.CouponInterface;

@Service
public class CouponService implements CouponInterface{

	@Autowired
	CouponDao couponDao;
	
	//Showing all types of Coupon
	@Override
	public List<Coupon> findAll() {
		return (List<Coupon>) couponDao.findAll();
	}

	//Finding specific Coupon by Id
	@Override
	public Coupon findById(Long id) {
		Optional<Coupon> optionalCoupon = couponDao.findById(id);
		if(optionalCoupon.isPresent()) {
			return optionalCoupon.get();
		}
		return null;
	}

	//Adding new type of Coupon
	@Override
	public Coupon save(CouponDto couponDto) {
		Coupon coupon = new Coupon();
		coupon.setCouponType(couponDto.getCouponType());
		coupon.setCouponDiscount(couponDto.getCouponDiscount());
		couponDao.save(coupon);
		return coupon;
	}

	//Updating existing Coupon
	@Override
	public Coupon update(Coupon coupon) {	
		return couponDao.save(coupon);
	}

	//Deleting existing Coupon
	@Override
	public String delete(Long id) {
		couponDao.deleteById(id);
		return "Object deleted!!!";
	}

}
