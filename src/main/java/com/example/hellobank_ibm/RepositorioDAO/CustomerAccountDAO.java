package com.example.hellobank_ibm.RepositorioDAO;

import com.example.hellobank_ibm.Model.CustomerAccountModel;

import org.springframework.data.repository.CrudRepository;

public interface CustomerAccountDAO extends CrudRepository<CustomerAccountModel, Integer> {

}
