package com.example.hellobank_ibm.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.hellobank_ibm.Model.CustomerModel;
import com.example.hellobank_ibm.Service.CustomerServiceImp;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CustomerControllerTest {

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Autowired
	private CustomerServiceImp clienteService;

	@Test
	@DisplayName("Listar todos os Clientes")
	public void deveMostrarTodosClientes() {

		clienteService.criarnovo(new CustomerModel("Jayanne Mirelly", "10212014055", "jay@gmail.com", "Rua Code, 45"));

		clienteService.criarnovo(new CustomerModel("Ricardo Melo", "10670420566", "melo@gmail.com", "Rua Nove, 85"));

		ResponseEntity<String> resposta = testRestTemplate.withBasicAuth("root", "root").exchange("/customer",
				HttpMethod.GET, null, String.class);

		assertEquals(HttpStatus.OK, resposta.getStatusCode());
	}

}
