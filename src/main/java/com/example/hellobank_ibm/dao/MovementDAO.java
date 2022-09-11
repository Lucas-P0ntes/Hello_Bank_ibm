package com.example.hellobank_ibm.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.hellobank_ibm.model.MovementModel;

public interface MovementDAO extends CrudRepository<MovementModel, Integer> {

}
