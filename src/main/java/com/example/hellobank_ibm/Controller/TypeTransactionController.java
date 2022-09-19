package com.example.hellobank_ibm.Controller;

import com.example.hellobank_ibm.Model.TypeTransactionModel;
import com.example.hellobank_ibm.Service.ITypeTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class TypeTransactionController {
    @Autowired
    private ITypeTransaction service;

    @GetMapping("/TypeTransaction")
    public ArrayList<TypeTransactionModel> recuperarTodos() {
        return service.buscartodos();
    }

    @GetMapping("/TypeTransaction/{id}")
    public ResponseEntity<TypeTransactionModel> buscarPeloId(@PathVariable Integer id) {
        TypeTransactionModel res = service.buscarpeloid(id);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/TypeTransaction")
    public ResponseEntity<TypeTransactionModel> incluirNovo(@RequestBody TypeTransactionModel novo) {
        TypeTransactionModel res = service.criarnovo(novo);
        if (res != null) {

            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }
    @PutMapping("/TypeTransaction")
    public ResponseEntity<TypeTransactionModel> Atualizar(@RequestBody TypeTransactionModel novo) {
        TypeTransactionModel res = service.atualizardados(novo);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

}
