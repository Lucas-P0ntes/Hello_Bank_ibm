package com.example.hellobank_ibm.Model;

import javax.persistence.*;


@Entity
@Table(name = "type_movement")
public class TypeMovementModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String type_movement;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType_movement() {
		return type_movement;
	}

	public void setType_movement(String type_movement) {
		this.type_movement = type_movement;
	}
}
