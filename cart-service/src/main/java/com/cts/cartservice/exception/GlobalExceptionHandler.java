package com.cts.cartservice.exception;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(value=CartEmptyException.class)
	public ResponseEntity<Object> handleCartEmptyException(CartEmptyException e){
		log.info("Inside handleCartEmptyException Handler");
		String error=e.getLocalizedMessage();
		Map<String,Object> body=new LinkedHashMap<String, Object>();
		body.put("timeStamp",new Date());
		
		if(error==null) {
			error.toString();
		}
		body.put("errors",error);
		body.put("error-message","Cart is Empty");
		return new ResponseEntity(body,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=UserNotFoundException.class)
	public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException e){
		log.info("Inside handleUserNotFoundException Handler");
		String error=e.getLocalizedMessage();
		Map<String,Object> body=new LinkedHashMap<String, Object>();
		body.put("timeStamp",new Date());
	
		if(error==null) {
			error.toString();
		}
		body.put("errors",error);
		body.put("error-message","User Not Found");
		return new ResponseEntity(body,HttpStatus.NOT_FOUND);
	}
}
