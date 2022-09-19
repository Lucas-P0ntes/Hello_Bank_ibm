package com.example.hellobank_ibm.RepositorioDAO;

import com.example.hellobank_ibm.Model.TypeMovementModel;
import org.springframework.data.repository.CrudRepository;

public interface TypeMovementDAO extends CrudRepository<TypeMovementModel, Integer> {
}
