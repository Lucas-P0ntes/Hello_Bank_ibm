package com.example.hellobank_ibm.RepositorioDAO;

import com.example.hellobank_ibm.Model.MovementModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.hellobank_ibm.Model.TransactionModel;

import java.util.ArrayList;

public interface TransactionDAO extends CrudRepository<TransactionModel, Integer> {
    @Query(value = "SELECT * FROM transaction WHERE account_send = ?1 or account_receive = ?1 ",  nativeQuery=true)
    ArrayList<TransactionModel> historicoTransactiont(Integer id);

}
