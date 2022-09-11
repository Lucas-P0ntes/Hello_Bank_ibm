package com.example.hellobank_ibm.Service;

import com.example.hellobank_ibm.Model.CustomerAccountModel;

import com.example.hellobank_ibm.RepositorioDAO.CustomerAccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomerAccountImpl implements ICustomerAccount{
    @Autowired
    private CustomerAccountDAO dao;

    @Override
    public CustomerAccountModel criarnovo(CustomerAccountModel novo) {
        dao.save(novo);

        return null;
    }

    @Override
    public CustomerAccountModel atualizardados(CustomerAccountModel dados) {
        dao.save(dados);
        return null;
    }

    @Override
    public ArrayList<CustomerAccountModel> buscartodos() {

        ArrayList<CustomerAccountModel> all= (ArrayList<CustomerAccountModel>) dao.findAll();
        return all;
    }

    @Override
    public CustomerAccountModel buscarpeloid(Integer id) {
     return dao.findById(id).orElse(null);


    }

    @Override
    public CustomerAccountModel excluirConta(Integer id) {
        dao.deleteById(id);
        return null;
    }
}
