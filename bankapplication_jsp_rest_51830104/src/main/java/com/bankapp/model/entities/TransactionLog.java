package com.bankapp.model.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="transaction_log5")
public class TransactionLog {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private LocalDateTime timeStamp;
	private Long fromAccount;
	private Long toAccount;
	private String txType;
	private double txAmount;
	private String authname;
	private String status;// Approved, pending
	
	
	
	public TransactionLog() {
		
	}



	public TransactionLog(Long fromAccount, Long toAccount, String txType, double txAmount,
			String authname, String status) {
		this.timeStamp = LocalDateTime.now();
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.txType = txType;
		this.txAmount = txAmount;
		this.authname = authname;
		this.status = status;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}



	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}



	public Long getFromAccount() {
		return fromAccount;
	}



	public void setFromAccount(Long fromAccount) {
		this.fromAccount = fromAccount;
	}



	public Long getToAccount() {
		return toAccount;
	}



	public void setToAccount(Long toAccount) {
		this.toAccount = toAccount;
	}



	public String getTxType() {
		return txType;
	}



	public void setTxType(String txType) {
		this.txType = txType;
	}



	public double getTxAmount() {
		return txAmount;
	}



	public void setTxAmount(double txAmount) {
		this.txAmount = txAmount;
	}



	public String getAuthname() {
		return authname;
	}



	public void setAuthname(String authname) {
		this.authname = authname;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	@Override
	public String toString() {
		return "TransactionLog [id=" + id + ", timeStamp=" + timeStamp + ", fromAccount=" + fromAccount + ", toAccount="
				+ toAccount + ", txType=" + txType + ", txAmount=" + txAmount + ", authname=" + authname
				+ ", status=" + status + "]";
	}
	
	
	
}
