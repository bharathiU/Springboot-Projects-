package com.bankapp.model.service;

import java.util.List;

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.Customer;
import com.bankapp.model.entities.TransactionLog;
import com.bankapp.model.entities.User;

public interface AccountService {
	void blockAccount(Long accountNumber);
    Account createAccount(Account account );
    Account deposit(Long accountNumber, double amount);
    Account withdraw(Long accountNumber, double amount);
	public List<Account> getAllAccounts();
	public List<Account> findAll();
	public Account findByAccountNumber(long accno);
	Account updateAccount(long id, Account account);
	void deleteAccount(Long id);
	void deposit(Long accountNumber, Double amount, String name);
	void transfer(Long fromAccNumber, Long toAccNumber, double amount, String authname);
	
}
