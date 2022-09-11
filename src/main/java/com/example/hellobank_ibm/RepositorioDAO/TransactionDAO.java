package com.example.hellobank_ibm.RepositorioDAO;

import org.springframework.data.repository.CrudRepository;

import com.example.hellobank_ibm.Model.TransactionModel;

public interface TransactionDAO extends CrudRepository<TransactionModel, Integer> {

}