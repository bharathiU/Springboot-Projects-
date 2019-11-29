package com.bankapp.model.exceptions;

public class UserNotFoundException extends RuntimeException{

	public UserNotFoundException(String msg){
		super(msg);
	}
	private static final long serialVersionUID = 1L;

}
