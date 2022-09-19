package com.example.hellobank_ibm.Service;

import com.example.hellobank_ibm.Model.TypeMovementModel;
import com.example.hellobank_ibm.RepositorioDAO.TypeMovementDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class TypeMovementImp implements ITypeMovement{
    @Autowired
    private TypeMovementDAO dao;
    @Override
    public TypeMovementModel criarnovo(TypeMovementModel novo) {

        if(novo.getType_movement() != null){

            return dao.save(novo);
        }
        return null;
    }

    @Override
    public TypeMovementModel atualizardados(TypeMovementModel dados) {
        if(dados.getType_movement()!=null){
            return   dao.save(dados);
        }
        return null;
    }

    @Override
    public ArrayList<TypeMovementModel> buscartodos() {
        ArrayList<TypeMovementModel> all = (ArrayList<TypeMovementModel>)dao.findAll();
        return all;

    }

    @Override
    public TypeMovementModel buscarpeloid(Integer id) {
        return dao.findById(id).orElse(null);

    }
}
