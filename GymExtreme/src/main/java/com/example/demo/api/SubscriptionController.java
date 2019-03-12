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

import com.example.demo.dao.SubscriptionDao;
import com.example.demo.domain.Subscription;
import com.example.demo.domain.dto.SubscriptionDto;
import com.example.demo.service.implementation.SubscriptionService;

@RestController
@RequestMapping("/subscription")
public class SubscriptionController {

	@Autowired
	SubscriptionDao subscriptionDao;
	
	@Autowired
	SubscriptionService subscriptionService;
	
	//Showing all types of Subscription
	@RequestMapping(value="/findAll", method=RequestMethod.GET)
	public List<Subscription> findAll(){
		return subscriptionService.findAll();
	}
	
	//Finding specific Subscription by Id
	@RequestMapping("/find/{id}")
	public Subscription getSubscription(@PathVariable Long id){
		return subscriptionService.findById(id);
		
	}
	
	//Adding new type of Subscription
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public @ResponseBody Subscription subscription(@RequestBody SubscriptionDto subscriptionDto) {
		return subscriptionService.save(subscriptionDto);
	}
	
	//Updating existing Subscription
	@PutMapping(value = "/update")
	public Subscription update(@RequestBody Subscription subscription) {
		return subscriptionService.update(subscription);
	}
	
	//Deleting existing Subscription
	@DeleteMapping(value = "/delete")
	public String delete(@RequestParam Long id) {
		return subscriptionService.delete(id);
	}
}
