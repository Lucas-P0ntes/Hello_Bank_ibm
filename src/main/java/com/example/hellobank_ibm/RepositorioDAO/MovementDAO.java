package com.example.hellobank_ibm.RepositorioDAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hellobank_ibm.Model.MovementModel;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;

public interface MovementDAO extends JpaRepository<MovementModel, Integer> {
    @Query(value = "SELECT * FROM movement WHERE account = ?1 ",  nativeQuery=true)
    ArrayList<MovementModel> historicoMovement(Integer id);

}
