package com.cts.cartservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason = "User Not Found")
public class UserNotFoundException extends Exception{

	public UserNotFoundException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}

}
