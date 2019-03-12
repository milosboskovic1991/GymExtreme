package com.example.demo.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.SubscriptionDao;
import com.example.demo.domain.Subscription;
import com.example.demo.domain.dto.SubscriptionDto;
import com.example.demo.service.SubscriptionInterface;

@Service
public class SubscriptionService implements SubscriptionInterface{

	@Autowired
	SubscriptionDao subscriptionDao;
	
	//Showing all types of Subscription
	@Override
	public List<Subscription> findAll() {
		return (List<Subscription>) subscriptionDao.findAll();
	}

	//Finding specific Subscription by Id
	@Override
	public Subscription findById(Long id) {
		Optional<Subscription> optionalSubscription = subscriptionDao.findById(id);
		if(optionalSubscription.isPresent()) {
			return optionalSubscription.get();
		}
		return null;
	}

	//Adding new type of Subscription
	@Override
	public Subscription save(SubscriptionDto subscriptionDto) {
		Subscription subscription = new Subscription();
		subscription.setSubType(subscriptionDto.getSubType());
		subscription.setValidFrom(subscriptionDto.getValidFrom());
		subscription.setValidTo(subscriptionDto.getValidTo());
		subscription.setPrice(subscriptionDto.getPrice());	
		subscriptionDao.save(subscription);
		return subscription;
	}

	//Updating existing Subscription
	@Override
	public Subscription update(Subscription subscription) {
		return subscriptionDao.save(subscription);	 
	}
	
	//Deleting existing Subscription
	@Override
	public String delete(Long id) {
		subscriptionDao.deleteById(id);
		return "Object deleted!!!";
	}

}
