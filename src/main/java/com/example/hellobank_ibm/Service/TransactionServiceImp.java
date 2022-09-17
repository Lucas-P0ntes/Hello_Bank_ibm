package com.example.hellobank_ibm.Service;

import java.util.ArrayList;

import com.example.hellobank_ibm.Funcao.ConvertMoney;
import com.example.hellobank_ibm.Model.CustomerAccountModel;
import com.example.hellobank_ibm.Model.MovementModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hellobank_ibm.Model.TransactionModel;
import com.example.hellobank_ibm.RepositorioDAO.TransactionDAO;

@Service
public class TransactionServiceImp implements ITransactionService {

	@Autowired
	private TransactionDAO dao;
	@Autowired
	private ICustomerAccount service;

	ConvertMoney convertMoney =new ConvertMoney();
	@Override
	public TransactionModel criarNovo(TransactionModel novo) {
		if(novo.getType()==1) {
			novo.setValor(convertMoney.reaisParaCent(novo.getValor()));
			CustomerAccountModel res =this.service.pixSaldo(novo.getAccount_send(), novo.getAccount_receive(),novo.getValor());
			if(res!= null) {
				return dao.save(novo);
			}
			return null;
		}else{
			novo.setValor(convertMoney.reaisParaCent(novo.getValor()));
			CustomerAccountModel res =this.service.pixSaldo(novo.getAccount_send(), novo.getAccount_receive(),novo.getValor());
			if(res!= null) {
				return dao.save(novo);
			}
			return null;
		}

	}



	@Override
	public ArrayList<TransactionModel> buscarTodos() {
		ArrayList<TransactionModel> all = (ArrayList<TransactionModel>) dao.findAll();
		return all;
	}

	@Override
	public TransactionModel buscarPeloId(Integer id) {

		TransactionModel res = dao.findById(id).orElse(null);
		res.setValor(convertMoney.centParaReais(res.getValor()));
		return res;
	}


}
