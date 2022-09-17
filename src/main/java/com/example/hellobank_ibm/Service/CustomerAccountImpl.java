package com.example.hellobank_ibm.Service;

import com.example.hellobank_ibm.Funcao.ConvertMoney;
import com.example.hellobank_ibm.Model.CustomerAccountModel;

import com.example.hellobank_ibm.Model.MovementModel;
import com.example.hellobank_ibm.RepositorioDAO.CustomerAccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.Random;

@Service
public class CustomerAccountImpl implements ICustomerAccount{
    @Autowired
    private CustomerAccountDAO dao;
    ConvertMoney convertMoney= new ConvertMoney();
    @Override
    public CustomerAccountModel criarnovo(Integer key) {
        Random gerador = new Random();
       String contaNum= String.valueOf(gerador.nextInt(10000));
        CustomerAccountModel newConta = new CustomerAccountModel("0001",contaNum,0, key);
        return dao.save(newConta);
    }

    @Override
    public CustomerAccountModel atualizardados(CustomerAccountModel dados) {
        return dao.save(dados);
    }
    @Override
    public CustomerAccountModel depositaSaldo(Integer key , Integer valor ) {
        CustomerAccountModel newSaldo = this.buscarpeloid(key);
        newSaldo.setSaldo(newSaldo.getSaldo() + valor );
        return dao.save(newSaldo);
    }
    @Override
    public CustomerAccountModel sacaSaldo(Integer key , Integer valor ) {
        CustomerAccountModel newSaldo = this.buscarpeloid(key);
            if(newSaldo.getSaldo() - valor >=0 ){
                newSaldo.setSaldo(newSaldo.getSaldo() - valor );
                return dao.save(newSaldo);

            }
            return null;

    }

    @Override
    public CustomerAccountModel pixSaldo(Integer send, Integer receive, Integer valor) {
        CustomerAccountModel sendSaldo = this.buscarpeloid(send);
        CustomerAccountModel receiveSaldo = this.buscarpeloid(receive);
        if(sendSaldo.getSaldo() - valor >=0 ){
            sendSaldo.setSaldo(sendSaldo.getSaldo() - valor );
            receiveSaldo.setSaldo(receiveSaldo.getSaldo() + valor );
            dao.save(receiveSaldo);
             dao.save(sendSaldo);
             return dao.save(sendSaldo);
        }
        return null;
    }

    @Override
    public CustomerAccountModel trasferirSaldo(Integer send, Integer receive, Integer valor) {
        CustomerAccountModel sendSaldo = this.buscarpeloid(send);
        CustomerAccountModel receiveSaldo = this.buscarpeloid(receive);
        if(sendSaldo.getSaldo() - valor >=0 ){
            sendSaldo.setSaldo(sendSaldo.getSaldo() - valor );
            receiveSaldo.setSaldo(receiveSaldo.getSaldo() + valor );
            dao.save(receiveSaldo);
            dao.save(sendSaldo);
            return dao.save(sendSaldo);
        }
        return null;
    }

    @Override
    public ArrayList<CustomerAccountModel> buscartodos() {

        ArrayList<CustomerAccountModel> all= (ArrayList<CustomerAccountModel>) dao.findAll();
        return all;
    }

    @Override
    public CustomerAccountModel buscarpeloid(Integer id) {
        CustomerAccountModel res = dao.findById(id).orElse(null);
        res.setSaldo(convertMoney.centParaReais(res.getSaldo()));
        return res;
    }

    @Override
    public CustomerAccountModel excluirConta(Integer id) {
        dao.deleteById(id);
        return null;
    }
}
