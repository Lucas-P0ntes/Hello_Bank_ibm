package com.example.hellobank_ibm.Controller;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.hellobank_ibm.Model.CustomerModel;
import com.example.hellobank_ibm.Service.ICustomerService;

@RestController
public class CustomerController {

    @Autowired
    private ICustomerService service;

    @GetMapping("/customer")
    public ArrayList<CustomerModel> Recuperartodos(){
        return service.buscartodos();
    }
    @GetMapping("/customer/{id}")
    public ResponseEntity <CustomerModel> buscarPeloId(@PathVariable Integer id){
        CustomerModel res= service.buscarpeloid(id);
        if(res !=null){
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.notFound().build();
    }
    @PutMapping( "/customer")
    public ResponseEntity <CustomerModel> atualizarDados(@RequestBody CustomerModel dados){
        CustomerModel res= service.atualizardados(dados);
        if(res !=null){
            return ResponseEntity.ok(res);

        }
        return ResponseEntity.badRequest().build();
    }
    @PostMapping("/customer")
    public ResponseEntity <CustomerModel> criarNovo(@RequestBody CustomerModel novo){
        CustomerModel res= service.criarnovo(novo);
        if(res !=null){
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/customer/{id}")
    public ResponseEntity <CustomerModel> apagarConta(@PathVariable Integer id ){
        CustomerModel res = service.excluircliente(id);

            return null;

    }



}




