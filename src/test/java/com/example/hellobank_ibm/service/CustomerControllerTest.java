package com.example.hellobank_ibm.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.hellobank_ibm.Controller.*;
import com.example.hellobank_ibm.Model.CustomerModel;
import com.example.hellobank_ibm.Service.*;

public class CustomerControllerTest {

	@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
	@TestInstance(TestInstance.Lifecycle.PER_CLASS)
	@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
	public class clienteControllerTest {

		@Autowired
		private TestRestTemplate testRestTemplate;

		@Autowired
		private CustomerServiceImp clienteService;

		@Test
		@Order(1)
		@DisplayName("criar novo")
		public void deveCriarUmCliente() {

			HttpEntity<CustomerController> requisicao = new HttpEntity<CustomerController>(
					new CustomerModel(0L, "Juliana Pereira", "Sao Paulo", "00011122233", null));

			ResponseEntity<CustomerModel> resposta = testRestTemplate.exchange("/cliente/cadastrar", HttpMethod.POST,
					requisicao, CustomerModel.class);

			assertEquals(HttpStatus.CREATED, resposta.getStatusCode());
			assertEquals(requisicao.getBody().getNomeCompleto(), resposta.getBody().getNome_completo());
			assertEquals(requisicao.getBody().getEndereco(), resposta.getBody().getEndereco());
			assertEquals(requisicao.getBody().getCpf(), resposta.getBody().getCpf());
		}

		@Test
		@Order(2)
		@DisplayName("Não deve permitir duplicação de Cliente")
		public void naoDeveDuplicarCliente() {

			CustomerAccountController.cadastrarCliente(new CustomerModel(0L, "Jose de Paula", "12345678910", null));

			HttpEntity<CustomerModel> requisicao = new HttpEntity<CustomerModel>(
					new CustomerModel(0L, "Jose de Paula", "12345678910", null));

			ResponseEntity<CustomerModel> resposta = testRestTemplate.exchange("/cliente/cadastrar", HttpMethod.POST,
					requisicao, CustomerModel.class);

			assertEquals(HttpStatus.BAD_REQUEST, resposta.getStatusCode());
		}

		@Test
		@Order(3)
		@DisplayName("Alterar dados cadastrais do Cliente")
		public void deveAtualizarUmCliente() {

			Optional<CustomerModel> clienteCreate = clienteService
					.cadastrarCliente(new CustomerModel(0L, "Maria dos Santos", "98765432199", null));

			CustomerModel clienteUpdate = new CustomerModel(clienteCreate.get().getIdCliente(), "Maria dos Santos Soares"
					, "98765432199", null);

			HttpEntity<CustomerModel> requisicao = new HttpEntity<CustomerModel>(clienteUpdate);

			ResponseEntity<CustomerModel> resposta = testRestTemplate.withBasicAuth("root", "root")
					.exchange("/cliente/atualizar", HttpMethod.PUT, requisicao, CustomerModel.class);

			assertEquals(HttpStatus.OK, resposta.getStatusCode());
			assertEquals(clienteUpdate.getNome_completo(), resposta.getBody().getNome_completo());
			assertEquals(clienteUpdate.getEndereco(), resposta.getBody().getEndereco());
		}

		@Test
		@Order(4)
		@DisplayName("Listar todos os Clientes")
		public void deveMostrarTodosClientes() {

			clienteService.cadastrarCliente(new CustomerModel(0L, "Gustavo Melo", "Brasilia", "12367834500", null));

			clienteService.cadastrarCliente(new CustomerModel(0L, "Giovana Queiroz", "Salvador", "98712365400", null));

			ResponseEntity<String> resposta = testRestTemplate.withBasicAuth("root", "root").exchange("/clientes/all",
					HttpMethod.GET, null, String.class);

			assertEquals(HttpStatus.OK, resposta.getStatusCode());
		}

	}

}
