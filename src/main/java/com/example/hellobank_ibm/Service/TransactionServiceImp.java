package com.example.hellobank_ibm.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hellobank_ibm.model.TransactionModel;
import com.example.hellobank_ibm.repository.TransactionDAO;

@Service
public class TransactionServiceImp implements ITransactionService {

	@Autowired
	private TransactionDAO dao;

	@Override
	public TransactionModel criarNovo(TransactionModel novo) {
		if (novo.getId() != null && novo.getHora() != null && novo.getTipo() != null && novo.getValor() != null) {
			return dao.save(novo);
		}
		return null;
	}

	@Override
	public TransactionModel atualizarDados(TransactionModel dados) {
		if (dados.getId() != null && dados.getHora() != null && dados.getTipo() != null && dados.getValor() != null) {
			return dao.save(dados);
		}
		return null;
	}

	@Override
	public ArrayList<TransactionModel> buscarTodos() {
		ArrayList<TransactionModel> all = (ArrayList<TransactionModel>) dao.findAll();
		return all;
	}

	@Override
	public TransactionModel buscarPeloId(Integer id) {

		return dao.findById(id).orElse(null);
	}

	@Override
	public TransactionModel excluirTransaction(Integer id) {
		dao.deleteById(id);
		return null;
	}
}
