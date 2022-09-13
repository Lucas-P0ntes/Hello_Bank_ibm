package com.example.hellobank_ibm.Model;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movement")
public class MovementModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer valor;

	private Timestamp data;

	public Integer getAccount_custumer() {
		return account_custumer;
	}

	public void setAccount_custumer(Integer account_custumer) {
		this.account_custumer = account_custumer;
	}

	private Integer account_custumer;
	public Timestamp getData() {
		return data;
	}

	private Integer type;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}




	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
}
