package com.example.hellobank_ibm.RepositorioDAO;

import com.example.hellobank_ibm.Model.TypeTransactionModel;
import org.springframework.data.repository.CrudRepository;

public interface TypeTransactionDAO extends CrudRepository<TypeTransactionModel, Integer> {
}
