package com.bankapp.web.controller.beans;

public class TransferRequest {
	private Long toaccount;
	private Long fromaccount;
	private Double amount;
	private String authname;
	
	
	public TransferRequest(Long toaccount, Long fromaccount, Double amount, String authname) {
		super();
		this.toaccount = toaccount;
		this.fromaccount = fromaccount;
		this.amount = amount;
		this.authname = authname;
	}

	public String getAuthname() {
		return authname;
	}

	public void setAuthname(String authname) {
		this.authname = authname;
	}

	public Long getToaccount() {
		return toaccount;
	}
	public void setToaccount(Long toaccount) {
		this.toaccount = toaccount;
	}
	public Long getFromaccount() {
		return fromaccount;
	}
	public void setFromaccount(Long fromaccount) {
		this.fromaccount = fromaccount;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public TransferRequest() {
		
	}
	
}
