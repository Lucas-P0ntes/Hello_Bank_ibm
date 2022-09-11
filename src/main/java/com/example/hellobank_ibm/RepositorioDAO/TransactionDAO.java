package com.example.hellobank_ibm.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.hellobank_ibm.model.TransactionModel;

public interface TransactionDAO extends CrudRepository<TransactionModel, Integer> {

}