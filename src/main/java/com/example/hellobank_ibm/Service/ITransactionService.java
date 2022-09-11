package com.example.hellobank_ibm.Service;

import java.util.ArrayList;

import com.example.hellobank_ibm.Model.TransactionModel;

public interface ITransactionService {

	public TransactionModel criarNovo(TransactionModel novo);

	public TransactionModel atualizarDados(TransactionModel dados);

	public ArrayList<TransactionModel> buscarTodos();

	public TransactionModel buscarPeloId(Integer id);

	public TransactionModel excluirTransaction(Integer id);
}