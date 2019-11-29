package com.bankapp.model.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.User;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
	public List<Account> findAll();

	public void save(User user);

	public Account findByAccountNumber(Long accountNumber);

/*	public void delete(Long id);
*/}
