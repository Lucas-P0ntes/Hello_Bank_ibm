package com.example.hellobank_ibm.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.example.hellobank_ibm.Model.*;
import com.example.hellobank_ibm.RepositorioDAO.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RepositorioDAOTest{

	@Autowired
	private CustomerDAO clienteRepository;

	@BeforeAll
	void start(){
		
		clienteRepository.save(new CustomerModel( "Tobias Gustavo da Silva Soares", "98765432112", "tobiasgustavoh@gmail.com,"
				+  "Rua Medeiros Furtado 189"));
		clienteRepository.save(new CustomerModel( "Lucas Pontes Santana", "12345678901", "lucaspontes@gmail.com", "Rua B QD 12 Brasilia"));
	}

	@Test
	@DisplayName("Retorna 2 clientes")
	public void deveRetornarDoisClientes() {

		List<CustomerModel> listaDeClientes = clienteRepository.findAll("Tobias");
		assertEquals(2, listaDeClientes.size());
		assertTrue(listaDeClientes.get(0).getNome_completo().equals("Tobias Gustavo da Silva Soares"));
		assertTrue(listaDeClientes.get(1).getNome_completo().equals("Lucas Pontes Santana"));
	}

}  	