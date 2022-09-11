package com.example.hellobank_ibm.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "typeMovement")
public class TypeMovementModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String typeMoviment;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTypeMoviment() {
		return typeMoviment;
	}
	public void setTypeMoviment(String typeMoviment) {
		this.typeMoviment = typeMoviment;
	}
	
}
