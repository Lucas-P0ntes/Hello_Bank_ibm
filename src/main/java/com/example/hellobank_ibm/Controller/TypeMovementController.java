package com.example.hellobank_ibm.Controller;

import com.example.hellobank_ibm.Model.TypeMovementModel;

import com.example.hellobank_ibm.Service.ITypeMovement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class TypeMovementController {
    @Autowired
    private ITypeMovement service;

    @GetMapping("/TypeMovement")
    public ArrayList<TypeMovementModel> recuperarTodos() {
        return service.buscartodos();
    }

    @GetMapping("/TypeMovement/{id}")
    public ResponseEntity<TypeMovementModel> buscarPeloId(@PathVariable Integer id) {
        TypeMovementModel res = service.buscarpeloid(id);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/TypeMovement")
    public ResponseEntity<TypeMovementModel> incluirNovo(@RequestBody TypeMovementModel novo) {
        TypeMovementModel res = service.criarnovo(novo);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }
    @PutMapping("/TypeMovement")
    public ResponseEntity<TypeMovementModel> Atualizar(@RequestBody TypeMovementModel novo) {
        TypeMovementModel res = service.atualizardados(novo);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }


}
