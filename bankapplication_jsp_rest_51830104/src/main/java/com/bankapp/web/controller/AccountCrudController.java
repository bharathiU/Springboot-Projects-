package com.bankapp.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.AccountTransaction;
import com.bankapp.model.entities.Customer;
import com.bankapp.model.entities.TransactionLog;
import com.bankapp.model.service.AccountService;
import com.bankapp.model.service.TransactionLogService;
import com.bankapp.web.controller.beans.AccountRequest;

@RestController
@RequestMapping(path = "/mgr/api")
public class AccountCrudController {
	@Autowired
	private AccountService service;
@Autowired
private TransactionLogService transactionLogService;

	@GetMapping(path = "/account", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Account>> getAllAccounts() {

		return new ResponseEntity<List<Account>>(service.getAllAccounts(), HttpStatus.OK);

	}
	@GetMapping(path = "/transactionlog", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TransactionLog>> getTransactionlog() {
		return new ResponseEntity<List<TransactionLog>>(transactionLogService.getTransactonLog(),HttpStatus.OK);
	}
	@GetMapping(path = "/account/transactions", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AccountTransaction> getAllTransactions(@PathVariable(name = "id") int id) {
		Account account = service.findByAccountNumber(id);
		List<AccountTransaction> transactions = account.getTransactionList();
		return transactions;
	}

	@GetMapping(path = "/account/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Resource<Account> getAnAccount(@PathVariable(name = "id") int id) {
		Account account = service.findByAccountNumber(id);
		Resource<Account> accountResource = new Resource<Account>(account);
		return accountResource;
	}

	@PostMapping(path = "/addaccount", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Account createAccount(@RequestBody AccountRequest req){
		Account account=new Account(req.getAccountBalance(),req.getBlocked());
		Customer customer=new Customer(req.getName(), req.getEmail(), req.getPhone(), req.getAddress(), req.getCity(), req.getCountry());
		customer.setAccount(account);
		account.setCustomer(customer);
		service.createAccount(account);
		return account;
	}

	@PutMapping(path = "/account/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> updateAccount(@PathVariable(name = "id") Long id, @RequestBody Account account) {
		return new ResponseEntity<Account>(service.updateAccount(id, account), HttpStatus.OK);
	}

	@DeleteMapping(path = "/account/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteAccount(@PathVariable(name = "id") Long id) {
		service.deleteAccount(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@GetMapping(path = "account/{id}")
	public Customer getAccountById(@PathVariable(value = "id") Long id) {
		Account account = service.findByAccountNumber(id);
		Customer customer = account.getCustomer();
		return customer;

	}
}
