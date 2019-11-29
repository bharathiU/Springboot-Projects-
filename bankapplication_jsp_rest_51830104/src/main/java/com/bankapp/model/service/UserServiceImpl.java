package com.bankapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.User;
import com.bankapp.model.exceptions.UserNotFoundException;
import com.bankapp.model.repo.AccountRepository;
import com.bankapp.model.repo.UserRepository;
import com.bankapp.model.service.exceptions.AccountNotFoundException;


@Service
public class UserServiceImpl implements UserService {

@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public void addUser(User user) {
      userRepository.save(user);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public void blockUser(Long userId) {
		
	}

	

	/*@Override
	public User findUserByAccountNumber(long id) {
		return userRepository.findUserByAccountNumber(id);
	}*/

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User updateUser(Long id, User user) {
		User userToBeUpdate = findUserByAccountNumber(id);
		userToBeUpdate.setPhone(user.getPhone());
		userRepository.save(userToBeUpdate);
		return userToBeUpdate;
	}

	@Override
	public void deleteUser(Long userId) {
userRepository.deleteById(userId);		
	}

	@Override
	public User findUserByAccountNumber(long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).orElseThrow(AccountNotFoundException::new);
	}

	
	
	}


