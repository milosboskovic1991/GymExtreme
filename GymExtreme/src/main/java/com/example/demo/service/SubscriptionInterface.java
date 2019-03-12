package com.example.demo.service;

import java.util.List;
import com.example.demo.domain.Subscription;
import com.example.demo.domain.dto.SubscriptionDto;

public interface SubscriptionInterface {
	
	public List<Subscription> findAll();
	
	public Subscription findById(Long id);
	
	public Subscription save(SubscriptionDto subscriptionDto);
	
	public Subscription update(Subscription subscription);
	
	public String delete(Long id);
	
}
