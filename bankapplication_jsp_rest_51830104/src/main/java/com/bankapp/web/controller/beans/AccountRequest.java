package com.bankapp.web.controller.beans;

public class AccountRequest {
	private Double accountBalance;
	private String type;
	private Boolean blocked;
	private String name;
	private String phone;
	private String email;
	private String address;
	private String city;
	private String country;
	
	public void setCity(String city) {
		this.city = city;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Boolean getBlocked() {
		return blocked;
	}
	public void setBlocked(Boolean blocked) {
		this.blocked = blocked;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getCity() {
		return city;
	}
	public String getCountry() {
		return country;
	}
	public AccountRequest(Double accountBalance, String type, Boolean blocked, String name, String phone, String email,
			String address, String city, String country) {
		super();
		this.accountBalance = accountBalance;
		this.type = type;
		this.blocked = blocked;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.city = city;
		this.country = country;
	}
	public AccountRequest() {
		
	}
	
}
