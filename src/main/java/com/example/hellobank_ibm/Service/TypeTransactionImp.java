package com.example.hellobank_ibm.Service;


import com.example.hellobank_ibm.Model.TypeTransactionModel;
import com.example.hellobank_ibm.RepositorioDAO.TypeTransactionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class TypeTransactionImp implements ITypeTransaction {
    @Autowired
    private TypeTransactionDAO dao;

    @Override
    public TypeTransactionModel criarnovo(TypeTransactionModel novo) {

        if(novo.getType_transaction()!=null){

            return dao.save(novo);

         }
        return null;
    }

    @Override
    public TypeTransactionModel atualizardados(TypeTransactionModel att) {

        if(att.getType_transaction()!=null){
            return dao.save(att);
        }
        return null;
    }

    @Override
    public ArrayList<TypeTransactionModel> buscartodos() {
        ArrayList<TypeTransactionModel> all = (ArrayList<TypeTransactionModel>)dao.findAll();
        return all;
    }

    @Override
    public TypeTransactionModel buscarpeloid(Integer id) {
        return dao.findById(id).orElse(null);

    }
}
