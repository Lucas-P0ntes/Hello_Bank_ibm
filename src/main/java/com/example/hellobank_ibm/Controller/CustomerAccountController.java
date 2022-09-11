package com.example.hellobank_ibm.Controller;


import com.example.hellobank_ibm.Model.CustomerAccountModel;
import com.example.hellobank_ibm.Service.ICustomerAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CustomerAccountController {
    @Autowired
    private ICustomerAccount service;

    @GetMapping("/account")
    public ArrayList<CustomerAccountModel>Recuperartodos(){
        return service.buscartodos();
    }
    @GetMapping("/account/{id}")
    public CustomerAccountModel  buscarPeloid(@PathVariable Integer id){
        return service.buscarpeloid(id);
    }
    @DeleteMapping("/account/{id}")
    public CustomerAccountModel  excluirConta(@PathVariable Integer id){
        return service.excluirConta(id);
    }
    @PutMapping ("/account")
    public CustomerAccountModel atualizar(@RequestBody CustomerAccountModel dados){
        return service.atualizardados(dados)
    }
    @PostMapping("/account")
    public CustomerAccountModel  criarNovo(@RequestBody CustomerAccountModel novo){
        return service.criarnovo(novo);
    }



}
