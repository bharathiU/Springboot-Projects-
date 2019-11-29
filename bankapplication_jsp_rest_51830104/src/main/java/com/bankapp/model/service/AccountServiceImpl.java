package com.bankapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.AccountTransaction;
import com.bankapp.model.entities.Customer;
import com.bankapp.model.entities.TransactionLog;
import com.bankapp.model.entities.User;
import com.bankapp.model.repo.AccountRepository;
import com.bankapp.model.repo.AccountTransactionRepository;
import com.bankapp.model.repo.CustomerRepository;
import com.bankapp.model.repo.TransactionalLogRepository;
import com.bankapp.model.service.exceptions.AccountNotFoundException;
import com.bankapp.model.service.exceptions.NotSufficientFundException;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private AccountTransactionRepository accountTransactionRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private TransactionalLogRepository transactionLogRepository;

	@Override
	public void blockAccount(Long accountNumber) {

	}

	@Override
	public Account createAccount(Account account) {
		accountRepository.save(account);
		// customerRepository.save(account.getCustomer());
		return account;

	}

	@Override
	public Account deposit(Long accountNumber, double amount) {
		Account account = accountRepository.findById(accountNumber).orElseThrow(AccountNotFoundException::new);
		account.setBalance(account.getBalance() + amount);
		AccountTransaction accountTransaction = new AccountTransaction("deposit", amount);
		account.addAccountTransaction(accountTransaction);
		accountRepository.save(account);
		TransactionLog log = new TransactionLog(accountNumber, null, "depoist", amount, "gunika", "done");
		transactionLogRepository.save(log);

		return account;
	}

	@Override
	public Account withdraw(Long accountNumber, double amount) {
		Account account = accountRepository.findById(accountNumber).orElseThrow(AccountNotFoundException::new);
		// min bal should be 1000 in any case
		if (account.getBalance() - amount < 1000)
			throw new NotSufficientFundException();
		account.setBalance(account.getBalance() - amount);
		accountRepository.save(account);
		return account;

	}

	@Override
	public void transfer(Long fromAccNumber, Long toAccNumber, double amount,String authname) {

		/*this.withdraw(fromAccNumber, amount);
		this.deposit(toAccNumber, amount);*/
		Account account1=accountRepository.findByAccountNumber(fromAccNumber);
		Account account2=accountRepository.findByAccountNumber(toAccNumber);
		account1.setBalance(account1.getBalance()-amount);
		account2.setBalance(account2.getBalance()+amount);
		accountRepository.save(account1);
		accountRepository.save(account2);
		AccountTransaction accountTransaction=new AccountTransaction("transactions", amount);
		account1.addAccountTransaction(accountTransaction);
		account2.addAccountTransaction(accountTransaction);
		TransactionLog log=new TransactionLog(fromAccNumber, toAccNumber, "transfer", amount, authname , "done");
		transactionLogRepository.save(log);

	}

	@Override
	public List<Account> getAllAccounts() {
		List<Account> accounts = accountRepository.findAll();
		return accounts;
	}

	@Override
	public List<Account> findAll() {
		return null;
	}

	@Override
	public Account findByAccountNumber(long accno) {
		return accountRepository.findById(accno).orElseThrow(AccountNotFoundException::new);
	}

	@Override
	public Account updateAccount(long id, Account account) {
		Account accountToBeUpdate = findByAccountNumber(id);
		accountToBeUpdate.setBalance(account.getBalance());
		accountToBeUpdate.setBlocked(account.isBlocked());
		return accountToBeUpdate;
	}

	@Override
	public void deleteAccount(Long id) {
		accountRepository.deleteById(id);
	}

	@Override
	public void deposit(Long accountNumber, Double amount, String name) {
		// TODO Auto-generated method stub
		
	}


	
	
}
