package com.bankapp.model.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankapp.model.entities.User;
@Repository
public interface UserRepository extends  JpaRepository<User, Long>{
	public User findByEmail(String email);
	//public User findUserByAccountNumber(long id);
	//public User createUser(User user);
	
	//public List<User> findAllCustomers();

}
