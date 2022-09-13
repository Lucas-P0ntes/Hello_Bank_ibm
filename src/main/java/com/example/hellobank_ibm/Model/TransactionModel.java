package com.example.hellobank_ibm.Model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
public class TransactionModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Timestamp data;

	private Integer account_send;
	private Integer account_receive;

	public void setData(Timestamp data) {
		this.data = data;
	}

	public Integer getAccount_send() {
		return account_send;
	}

	public void setAccount_send(Integer account_send) {
		this.account_send = account_send;
	}

	public Integer getAccount_receive() {
		return account_receive;
	}

	public void setAccount_receive(Integer account_receive) {
		this.account_receive = account_receive;
	}

	public Timestamp getData() {
		return data;
	}

	private Integer valor;
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
