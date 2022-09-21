package com.example.hellobank_ibm.RepositorioDAO;

import org.springframework.data.repository.CrudRepository;

import com.example.hellobank_ibm.Model.CustomerModel;

public interface CustomerDAO extends CrudRepository<CustomerModel, Integer> {

}
