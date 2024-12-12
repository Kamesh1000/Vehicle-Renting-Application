package com.example.vra.exception;

@SuppressWarnings("serial")
public class UserNotFoundException extends BaseException{
	
	public UserNotFoundException(String message) {
		super(message);
	}
}
