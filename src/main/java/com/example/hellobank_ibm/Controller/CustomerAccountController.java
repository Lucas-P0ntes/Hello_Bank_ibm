package com.example.hellobank_ibm.Controller;


import com.example.hellobank_ibm.Model.CustomerAccountModel;
import com.example.hellobank_ibm.Service.ICustomerAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CustomerAccountController {
    @Autowired
    private ICustomerAccount service;

    @GetMapping("/account")
    public ArrayList<CustomerAccountModel> Recuperartodos(){
       var res = service.buscartodos();
        if (res != null) {
            return res;
        }
        return null;
    }

    @GetMapping("/account/{id}")
    public ResponseEntity<CustomerAccountModel> buscarPeloid(@PathVariable Integer id){
        CustomerAccountModel res = service.buscarpeloid(id);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/account/{id}")
    public ResponseEntity<CustomerAccountModel>  excluirConta(@PathVariable Integer id){
        CustomerAccountModel res= service.excluirConta(id);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.notFound().build();
    }
    @PutMapping ("/account")
    public ResponseEntity<CustomerAccountModel> atualizar(@RequestBody CustomerAccountModel dados){
        CustomerAccountModel res= service.atualizardados(dados);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

}
