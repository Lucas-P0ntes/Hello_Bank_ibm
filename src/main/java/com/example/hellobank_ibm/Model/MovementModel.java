package com.example.hellobank_ibm.Model;


import java.sql.Timestamp;



import javax.persistence.*;

@Entity
@Table(name = "movement")
public class MovementModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer valor;

	private Timestamp data;

	private Integer account;
	private Integer type;


	public Integer getAccount_custumer() {
		return account;
	}

	public void setAccount_custumer(Integer account) {
		this.account = account;
	}

	public Timestamp getData() {
		return data;
	}


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
