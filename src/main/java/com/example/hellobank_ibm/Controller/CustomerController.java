package com.example.hellobank_ibm.Controller;

import com.example.hellobank_ibm.Model.CustomerModel;
import com.example.hellobank_ibm.Service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CustomerController {

    @Autowired
    private ICustomerService service;

    @GetMapping("/customer")
    public ArrayList<CustomerModel> Recuperartodos(){
        return service.buscartodos();
    }
    @GetMapping("/customer/{id}")
    public CustomerModel buscarPeloId(@PathVariable Integer id){
        return service.buscarpeloid(id);
    }
    @PutMapping("/customer")
    public CustomerModel atualizarDados(@RequestBody CustomerModel dados){
        return service.atualizardados(dados);
    }
    @PostMapping("/customer")
    public CustomerModel criarNovo(@RequestBody CustomerModel novo){

        return service.criarnovo(novo);

    }

    @DeleteMapping("/customer/{id}")
    public CustomerModel apagarConta(@PathVariable Integer id ){
        service.excluircliente(id);
        return null;

    }



}




