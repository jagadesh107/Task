package com.stock;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Item {
	@Id
	@GeneratedValue
	private Integer Id;
	private String name;
	private Integer quantity;

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public int getId() {
		return Id;
	}

	public String getName() {
		return name;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
}