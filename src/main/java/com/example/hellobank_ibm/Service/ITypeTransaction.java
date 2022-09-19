package com.example.hellobank_ibm.Service;

import com.example.hellobank_ibm.Model.TypeTransactionModel;

import java.util.ArrayList;

public interface ITypeTransaction {
    public TypeTransactionModel criarnovo(TypeTransactionModel novo);
    public TypeTransactionModel  atualizardados(TypeTransactionModel dados);
    public ArrayList<TypeTransactionModel> buscartodos ();
    public TypeTransactionModel buscarpeloid(Integer id);

}
