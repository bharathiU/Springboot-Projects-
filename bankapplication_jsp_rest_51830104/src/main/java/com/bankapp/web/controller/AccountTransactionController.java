package com.bankapp.web.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.TransactionLog;
import com.bankapp.model.service.AccountService;
import com.bankapp.model.service.TransactionLogService;
import com.bankapp.web.controller.beans.TransactionResponse;
import com.bankapp.web.controller.beans.TransferRequest;
import com.bankapp.web.controller.beans.WithDrawAndDepositRequest;

@RestController
@RequestMapping(path = "/clerk/api")
public class AccountTransactionController {
	@Autowired
	private AccountService service;

	/*@PostMapping(path = "/bank/deposit/{id}/{amount}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> depositInAccount(@PathVariable(name = "id") Long id,
			@PathVariable(name = "amount") Double amount) {

		return new ResponseEntity<Account>(service.deposit(id, amount), HttpStatus.OK);
	}

	@PostMapping(path = "/bank/withdraw/{id}/{amount}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> withdrawInAccount(@PathVariable(name = "id") long id,
			@PathVariable(name = "amount") Double amount) {

		return new ResponseEntity<Account>(service.withdraw(id, amount), HttpStatus.OK);
	}
	
	@GetMapping(path = "/transactionlog", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TransactionLog>> getTransactionlog() {
		return new ResponseEntity<List<TransactionLog>>(transactionLogService.getTransactonLog(),HttpStatus.OK);
	}

	@PostMapping(path = "/bank/transfer/{fromAcc}/{toAcc}/{amount}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> transferFromAccToAccount(@PathVariable(name = "fromAcc") long fromAcc,
			@PathVariable(name = "toAcc") long toAcc, @PathVariable(name = "amount") Double amount) {
		service.transfer(fromAcc, toAcc, amount);
		return new ResponseEntity<Account>(HttpStatus.OK);
	}*/
	
	@PostMapping(path = "/deposit", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TransactionResponse> deposit(@RequestBody WithDrawAndDepositRequest  request,TransactionResponse transactionResponse,Principal
			principal) {
		service.deposit(request.getAccountNumber(), request.getAmount());
		TransactionResponse transactionResponse1=new TransactionResponse(request.getAmount()+"your amount is deposited"+request.getAccountNumber());
		return ResponseEntity.ok().body(transactionResponse1);
	
}

	@PostMapping(path = "/withdraw", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TransactionResponse> withdraw(@RequestBody WithDrawAndDepositRequest  request,TransactionResponse transactionResponse,Principal
			principal) {
		service.deposit(request.getAccountNumber(), request.getAmount());
		TransactionResponse transactionResponse1=new TransactionResponse(request.getAmount()+"withdraw from ur account"+request.getAccountNumber());
		return ResponseEntity.ok().body(transactionResponse1);
	
}
	
	@PostMapping(path = "/transfer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TransactionResponse> transferFromAccToAccount(@RequestBody TransferRequest  transferRequest,TransactionResponse transactionResponse,Principal
			principal) {
		service.transfer(transferRequest.getFromaccount(), transferRequest.getToaccount(), transferRequest.getAmount(), transferRequest.getAuthname());
		TransactionResponse transactionResponse1=new TransactionResponse(transferRequest.getAmount()+"your amount is transfered"+transferRequest.getToaccount());
		return ResponseEntity.ok().body(transactionResponse1);
	
}
}
