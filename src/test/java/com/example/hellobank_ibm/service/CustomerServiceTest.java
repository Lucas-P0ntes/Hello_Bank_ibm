package com.example.hellobank_ibm.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.hellobank_ibm.Model.CustomerModel;
import com.example.hellobank_ibm.Service.CustomerServiceImp;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

@SpringBootTest
public class CustomerServiceTest {

	@Autowired
	CustomerServiceImp customerServiceImp;

	@Test
	public void adicionarClienteNoBanco() {
		CustomerModel cliente = new CustomerModel("Jayanne Mirelly", "10212014055", "jay@gmail.com", "Rua Code, 45");

		CustomerModel clienteSalvo = customerServiceImp.criarnovo(cliente);

		assertThat(clienteSalvo).isNotNull();
		assertThat(clienteSalvo.getId()).isNotNull();
		assertThat(cliente.getCpf()).isEqualTo(clienteSalvo.getCpf());
		assertThat(cliente.getEmail()).isEqualTo(clienteSalvo.getEmail());
		assertThat(cliente.getEndereco()).isEqualTo(clienteSalvo.getEndereco());
		assertThat(cliente.getNome_completo()).isEqualTo(clienteSalvo.getNome_completo());

	}

	@Test
	public void buscarClienteNoBancoPorId() {
		CustomerModel cliente = new CustomerModel("Jayanne Mirelly", "10212014055", "jay@gmail.com", "Rua Code, 45");

		CustomerModel clienteSalvo = customerServiceImp.criarnovo(cliente);
		Optional<CustomerModel> clienteBuscado = Optional.of(customerServiceImp.buscarpeloid(clienteSalvo.getId()));

		assertThat(clienteBuscado.isPresent()).isTrue();
		assertThat(clienteBuscado.get().getId()).isEqualTo(clienteSalvo.getId());
	}

	@Test
	public void atualizarDadosCliente() {
		CustomerModel cliente = new CustomerModel("Jayanne Mirelly", "10212014055", "jay@gmail.com", "Rua Code, 45");
		CustomerModel clienteSalvo = customerServiceImp.criarnovo(cliente);

		clienteSalvo.setNome_completo("Novo_nome");
		clienteSalvo.setCpf("12345678910");
		clienteSalvo.setEmail("novo@email.com");
		clienteSalvo.setEndereco("novo endereço");

		CustomerModel clienteAtualizado = customerServiceImp.atualizardados(clienteSalvo);

		assertThat(clienteAtualizado.getId()).isEqualTo(clienteSalvo.getId());
		assertThat(clienteAtualizado.getNome_completo()).isEqualTo(clienteSalvo.getNome_completo());
		assertThat(clienteAtualizado.getCpf()).isEqualTo(clienteSalvo.getCpf());
		assertThat(clienteAtualizado.getEmail()).isEqualTo(clienteSalvo.getEmail());
		assertThat(clienteAtualizado.getEndereco()).isEqualTo(clienteSalvo.getEndereco());

	}

}
