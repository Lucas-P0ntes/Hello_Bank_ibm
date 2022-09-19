package com.example.hellobank_ibm.Service;

import java.util.ArrayList;

import com.example.hellobank_ibm.Funcao.ConvertMoney;
import com.example.hellobank_ibm.Model.CustomerAccountModel;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.hellobank_ibm.Model.MovementModel;
import com.example.hellobank_ibm.RepositorioDAO.MovementDAO;

@Service

public class MovementServiceImp implements IMovementService {

	@Autowired
	private MovementDAO dao;


	@Autowired
	private ICustomerAccount service;

	ConvertMoney convertMoney =new ConvertMoney();
	@Override
	public MovementModel criarNovo(MovementModel novo) {

		if(novo.getType()==1) {
			novo.setValor(convertMoney.reaisParaCent(novo.getValor()));
			CustomerAccountModel res =this.service.sacaSaldo(novo.getAccount_custumer(),novo.getValor());

			if(res!= null) {
				return dao.save(novo);
			}
			return null;
		}else{
			novo.setValor(convertMoney.reaisParaCent(novo.getValor()));
			 this.service.depositaSaldo(novo.getAccount_custumer(),novo.getValor());
			return dao.save(novo);
		}

	}

	@Override
	public ArrayList<MovementModel> buscarTodos() {
		ArrayList<MovementModel> all = (ArrayList<MovementModel>) dao.findAll();

		return all;
	}

	@Override
	public MovementModel buscarPeloId(Integer id) {

		MovementModel res = dao.findById(id).orElse(null);
		if (res != null) {
			res.setValor(convertMoney.centParaReais(res.getValor()));
			return res;

		}

		return null;
	}

	@Override
	public ArrayList<MovementModel> buscarPelocustomer(Integer id) {
		ArrayList<MovementModel> all =  dao.historicoMovement(id);

		return all;

	}


}
