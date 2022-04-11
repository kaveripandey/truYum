package com.cts.cartservice.exception;

//@ResponseStatus(value=HttpStatus.NOT_FOUND, reason = "Cart Empty")
public class CartEmptyException extends Exception {

	public CartEmptyException(String message) {
		super(message);
	}
	
}
