package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "customer_id")
	@SequenceGenerator(name="customer_id",initialValue=1000,allocationSize=1)
	int id;
	String name;
	
	@OneToOne
	Car c;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Car getC() {
		return c;
	}
	public void setC(Car c) {
		this.c = c;
	}
}
