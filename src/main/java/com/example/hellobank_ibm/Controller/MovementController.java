package com.example.hellobank_ibm.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.hellobank_ibm.Model.MovementModel;
import com.example.hellobank_ibm.Service.IMovementService;

@RestController
public class MovementController {

	@Autowired
	private IMovementService service;

	@GetMapping("/movements")
	public ArrayList<MovementModel> recuperarTodos() {

		return service.buscarTodos();

	}
	@GetMapping("movements/customer/{id}")
	public ArrayList<MovementModel> Todos(@PathVariable Integer id) {
	var list 	=service.buscarPelocustomer(id);
		return list;
}


	@GetMapping("/movements/{id}")
	public ResponseEntity<MovementModel> buscarPeloId(@PathVariable Integer id) {
		MovementModel res = service.buscarPeloId(id);
		if (res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping("/movements")
	public ResponseEntity<MovementModel> incluirNovo(@RequestBody MovementModel novo) {
		MovementModel res = service.criarNovo(novo);
		if (res != null) {

			return ResponseEntity.ok(res);
		}
		return ResponseEntity.badRequest().build();
	}


}
