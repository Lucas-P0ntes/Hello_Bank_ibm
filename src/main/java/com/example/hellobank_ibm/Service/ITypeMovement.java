package com.example.hellobank_ibm.Service;

import com.example.hellobank_ibm.Model.CustomerModel;
import com.example.hellobank_ibm.Model.TypeMovementModel;

import java.util.ArrayList;

public interface ITypeMovement {

    public TypeMovementModel criarnovo(TypeMovementModel novo);
    public TypeMovementModel  atualizardados(TypeMovementModel dados);
    public ArrayList<TypeMovementModel> buscartodos ();
    public TypeMovementModel buscarpeloid(Integer id);

}
