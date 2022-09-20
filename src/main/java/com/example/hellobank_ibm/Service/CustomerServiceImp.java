package com.example.hellobank_ibm.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hellobank_ibm.Model.CustomerModel;
import com.example.hellobank_ibm.RepositorioDAO.CustomerDAO;

@Service
public class CustomerServiceImp implements ICustomerService {

	@Autowired
	private CustomerDAO dao;
	@Autowired
	private ICustomerAccount service;

	@Override
	public CustomerModel criarnovo(CustomerModel novo) {

		if (novo.getCpf() != null && novo.getEmail() != null && novo.getNome_completo() != null
				&& novo.getEndereco() != null) {
			CustomerModel save = dao.save(novo);
			this.service.criarnovo(novo.getId());
			return save;
		}

		return null;

	}

	@Override
	public CustomerModel atualizardados(CustomerModel dados) {
		if (dados.getId() != null && dados.getCpf() != null && dados.getEmail() != null
				&& dados.getNome_completo() != null && dados.getEndereco() != null) {
			return dao.save(dados);
		}
		return null;
	}

	@Override
	public ArrayList<CustomerModel> buscartodos() {
		ArrayList<CustomerModel> all = (ArrayList<CustomerModel>) dao.findAll();
		return all;
	}

	@Override
	public CustomerModel buscarpeloid(Integer id) {
		return dao.findById(id).orElse(null);

	}

	@Override
	public CustomerModel excluircliente(Integer id) {
		dao.deleteById(id);
		return null;
	}
}
