package com.customerapp.model.persistance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="user_table2")
/*@Table(name = "user_table", 
uniqueConstraints = { @UniqueConstraint(columnNames = { "email" }) })*/
public class Customer {
	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	
	@Column(unique=true)
	private String email;
	
	private String phoneno;
	private String address;

	
	
	public Customer() {
		
	}

	public Customer(int id, String name, String email, String phoneno, String address) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phoneno = phoneno;
		this.address = address;
	}

	public Customer(String name, String email, String phoneno, String address) {
		
		this.name = name;
		this.email = email;
		this.phoneno = phoneno;
		this.address = address;
		
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
