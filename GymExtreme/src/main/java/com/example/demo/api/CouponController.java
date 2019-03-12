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

import com.example.demo.dao.CouponDao;
import com.example.demo.domain.Coupon;
import com.example.demo.domain.dto.CouponDto;
import com.example.demo.service.implementation.CouponService;

@RestController
@RequestMapping("/coupon")
public class CouponController {

	@Autowired
	CouponDao couponDao;
	
	@Autowired
	CouponService couponService;
	
	//Showing all types of Coupon
	@RequestMapping(value="/findAll", method=RequestMethod.GET)
	public List<Coupon> findAll(){
		return couponService.findAll();
	}
	
	//Finding specific Coupon by Id
	@RequestMapping("/find/{id}")
	public Coupon getCoupon(@PathVariable Long id){
		return couponService.findById(id);
		
	}
	
	//Adding new type of Coupon
	@RequestMapping(value = "/save", method=RequestMethod.POST)
	public @ResponseBody Coupon save(@RequestBody CouponDto couponDto) {
		return couponService.save(couponDto);
	}
	
	//Updating existing Coupon
	@PutMapping(value = "/update")
	public Coupon update(@RequestBody Coupon coupon) {
		couponService.update(coupon);
		return coupon;
	}
	
	//Deleting existing Coupon
	@DeleteMapping(value = "/delete")
	public String delete(@RequestParam Long id) {
		return couponService.delete(id);
	}
}
