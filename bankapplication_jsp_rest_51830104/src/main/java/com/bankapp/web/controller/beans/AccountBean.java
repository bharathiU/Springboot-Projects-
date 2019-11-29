package com.bankapp.web.controller.beans;

public class AccountBean {
//	private String accountNumber;
	private Double accountBalance;
	//private String type;
	private boolean blocked;
	private String name;
	private String email;
	private String address;
	private String city;
	private String phone;
	private String country;
	

//	public String getAccountNumber() {
//		return accountNumber;
//	}
//
//	public void setAccountNumber(String accountNumber) {
//		this.accountNumber = accountNumber;
//	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}

//	public String getType() {
//		return type;
//	}
//
//	public void setType(String type) {
//		this.type = type;
//	}

	public boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}


	
	public AccountBean(Double accountBalance, String type, boolean blocked, String name,
			String email, String address, String city, String phone, String country) {
		super();
		//this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
		//this.type = type;
		this.blocked = blocked;
		this.name = name;
		this.email = email;
		this.address = address;
		this.city = city;
		this.phone = phone;
		this.country = country;
	}

	public AccountBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
