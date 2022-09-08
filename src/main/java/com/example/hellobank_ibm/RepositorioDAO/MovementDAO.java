package com.example.hellobank_ibm.RepositorioDAO;

import org.springframework.data.repository.CrudRepository;

import com.example.hellobank_ibm.Model.MovementModel;

public interface MovementDAO extends CrudRepository<MovementModel, Integer> {

}
