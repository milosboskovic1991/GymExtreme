package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.domain.Subscription;

@Repository
public interface SubscriptionDao extends CrudRepository<Subscription, Long>{

}
