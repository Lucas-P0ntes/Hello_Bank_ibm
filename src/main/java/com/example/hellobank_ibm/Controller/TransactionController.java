package com.example.hellobank_ibm.Controller;

import java.util.ArrayList;

import com.example.hellobank_ibm.Model.MovementModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.hellobank_ibm.Model.TransactionModel;
import com.example.hellobank_ibm.Service.ITransactionService;

@RestController
public class TransactionController {

	@Autowired
	private ITransactionService service;

	@GetMapping("/transaction")
	public ArrayList<TransactionModel> recuperarTodos() {
		return service.buscarTodos();
	}

	@GetMapping("/transaction/{id}")
	public ResponseEntity<TransactionModel> buscarPeloId(@PathVariable Integer id) {
		TransactionModel res = service.buscarPeloId(id);
		if (res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping("/transaction")
	public ResponseEntity<TransactionModel> incluirNovo(@RequestBody TransactionModel novo) {
		TransactionModel res = service.criarNovo(novo);
		if (res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.badRequest().build();
	}
	@GetMapping("/transaction/customer/{id}")
	public ArrayList<TransactionModel> Todos(@PathVariable Integer id) {
		var list 	=service.historicoTransactiont(id);
		return list;
	}

}