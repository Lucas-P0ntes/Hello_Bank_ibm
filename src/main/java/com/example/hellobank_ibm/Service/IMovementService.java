package com.example.hellobank_ibm.Service;

import java.util.ArrayList;

import com.example.hellobank_ibm.Model.MovementModel;

public interface IMovementService {

	public MovementModel criarNovo(MovementModel novo);


	public ArrayList<MovementModel> buscarTodos();

	public MovementModel buscarPeloId(Integer id);
	public ArrayList<MovementModel> buscarPelocustomer(Integer id);


}
