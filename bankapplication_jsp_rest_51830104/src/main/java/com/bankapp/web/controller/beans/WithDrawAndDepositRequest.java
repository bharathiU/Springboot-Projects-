package com.bankapp.web.controller.beans;

public class WithDrawAndDepositRequest {
	private Long accountNumber;
	private Double amount;
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public WithDrawAndDepositRequest(Long accountNumber, Double amount) {
		this.accountNumber = accountNumber;
		this.amount = amount;
	}
	public WithDrawAndDepositRequest() {
		
	}
	
}
