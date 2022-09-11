package com.example.hellobank_ibm.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.hellobank_ibm.model.TypeMovementModel;

@Repository
public interface TypeMovementDAO extends CrudRepository<TypeMovementModel, Integer>{

}
