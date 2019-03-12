package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.domain.Trainer;

@Repository
public interface TrainerDao extends CrudRepository<Trainer, Long>{

}
