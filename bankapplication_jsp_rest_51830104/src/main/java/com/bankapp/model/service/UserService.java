package com.bankapp.model.service;

import java.util.List;

import javax.validation.Valid;

import com.bankapp.model.entities.User;

public interface UserService {
	public User findByEmail(String email);
	public void addUser(User user);
	public List<User> findAll();
	public void blockUser(Long Id);
	public void deleteUser(Long userId);
	public User findUserByAccountNumber(long id);
	public List<User> getAllUsers();
	public User createUser( User user);
	public User updateUser(Long id, User user);

}
