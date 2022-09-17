package com.example.hellobank_ibm.Service;

import com.example.hellobank_ibm.Model.CustomerAccountModel;


import java.util.ArrayList;

public interface ICustomerAccount {

    public CustomerAccountModel criarnovo(Integer key);
    public CustomerAccountModel  atualizardados(CustomerAccountModel dados);
    public CustomerAccountModel  depositaSaldo(Integer key , Integer saldo);
    public CustomerAccountModel  sacaSaldo(Integer key , Integer saldo);
    public  CustomerAccountModel pixSaldo(Integer send , Integer receive , Integer valor);
    public CustomerAccountModel  trasferirSaldo(Integer send , Integer receive , Integer valor);
    public ArrayList<CustomerAccountModel> buscartodos ();
    public CustomerAccountModel buscarpeloid(Integer id);
    public CustomerAccountModel excluirConta(Integer id);
}
