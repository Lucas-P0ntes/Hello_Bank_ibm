package com.example.hellobank_ibm.Service;

import com.example.hellobank_ibm.Model.CustomerAccountModel;


import java.util.ArrayList;

public interface ICustomerAccount {

    public CustomerAccountModel criarnovo(CustomerAccountModel novo);
    public CustomerAccountModel  atualizardados(CustomerAccountModel dados);
    public ArrayList<CustomerAccountModel> buscartodos ();
    public CustomerAccountModel buscarpeloid(Integer id);
    public CustomerAccountModel excluirConta(Integer id);
}
