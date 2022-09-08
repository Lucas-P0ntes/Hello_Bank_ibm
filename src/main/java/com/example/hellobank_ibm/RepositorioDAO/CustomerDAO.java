package com.example.hellobank_ibm.RepositorioDAO;

import com.example.hellobank_ibm.Model.CustomerModel;
import org.springframework.data.repository.CrudRepository;

public interface CustomerDAO extends CrudRepository<CustomerModel, Integer> {
}
