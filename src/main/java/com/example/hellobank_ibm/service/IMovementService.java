package com.example.hellobank_ibm.service;

import java.util.ArrayList;

import com.example.hellobank_ibm.model.MovementModel;

public interface IMovementService {

	public MovementModel criarNovo(MovementModel novo);

	public MovementModel atualizarDados(MovementModel dados);

	public ArrayList<MovementModel> buscarTodos();

	public MovementModel buscarPeloId(Integer id);

	public MovementModel excluirMovement(Integer id);
}
