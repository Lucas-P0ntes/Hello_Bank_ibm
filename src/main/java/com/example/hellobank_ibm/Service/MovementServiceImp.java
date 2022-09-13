package com.example.hellobank_ibm.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hellobank_ibm.Model.MovementModel;
import com.example.hellobank_ibm.RepositorioDAO.MovementDAO;

@Service
public class MovementServiceImp implements IMovementService {

	@Autowired
	private MovementDAO dao;

	@Override
	public MovementModel criarNovo(MovementModel novo) {
		if (  novo.getType() != null && novo.getValor() != null) {
			return dao.save(novo);
		}
		return null;
	}

	@Override
	public MovementModel atualizarDados(MovementModel dados) {
		if (dados.getId() != null && dados.getType() != null && dados.getValor() != null) {
			return dao.save(dados);
		}
		return null;
	}

	@Override
	public ArrayList<MovementModel> buscarTodos() {
		ArrayList<MovementModel> all = (ArrayList<MovementModel>) dao.findAll();
		return all;
	}

	@Override
	public MovementModel buscarPeloId(Integer id) {

		return dao.findById(id).orElse(null);
	}

	@Override
	public MovementModel excluirMovement(Integer id) {
		dao.deleteById(id);
		return null;
	}
}
