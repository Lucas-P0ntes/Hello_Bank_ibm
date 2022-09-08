package com.example.hellobank_ibm.Service;

import com.example.hellobank_ibm.Model.CustomerModel;

import java.util.ArrayList;

public interface ICustomerService  {
    public CustomerModel criarnovo(CustomerModel novo);
    public CustomerModel  atualizardados(CustomerModel dados);
    public ArrayList<CustomerModel> buscartodos ();
    public CustomerModel buscarpeloid(Integer id);
    public CustomerModel excluircliente(Integer id);
}
