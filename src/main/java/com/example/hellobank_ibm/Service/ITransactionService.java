package com.example.hellobank_ibm.service;

import java.util.ArrayList;

import com.example.hellobank_ibm.model.TransactionModel;

public interface ITransactionService {

	public TransactiontModel criarNovo(TransactionModel novo);

	public TransactionModel atualizarDados(TransactionModel dados);

	public ArrayList<TransactionModel> buscarTodos();

	public TransactionModel buscarPeloId(Integer id);

	public TransactionModel excluirTransaction(Integer id);
}