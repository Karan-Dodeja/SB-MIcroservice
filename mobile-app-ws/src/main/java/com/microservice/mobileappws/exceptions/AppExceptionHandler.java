package com.microservice.mobileappws.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.microservice.mobileappws.model.ErrorMessage;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<Object> handleAnyexception(Exception ex, WebRequest request) {
		
		String errorMessageDesc = ex.getLocalizedMessage();
		
		if(errorMessageDesc == null) errorMessageDesc=ex.toString();
		
		ErrorMessage errorMessage = new ErrorMessage(new Date(), ex.getLocalizedMessage());
		
		return new ResponseEntity<>(
				errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);		
		}
	
	
	@ExceptionHandler(value = {NullPointerException.class, UserServiceException.class})
	public ResponseEntity<Object> handleNullPointerexception(Exception ex, WebRequest request) {
		
		String errorMessageDesc = ex.getLocalizedMessage();
		
		if(errorMessageDesc == null) errorMessageDesc=ex.toString();
		
		ErrorMessage errorMessage = new ErrorMessage(new Date(), ex.getLocalizedMessage());
		
		return new ResponseEntity<>(
				errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);		
		}
	
	// @ExceptionHandler(value = {UserServiceException.class})
	// public ResponseEntity<Object> handleUserServiceexception(UserServiceException ex, WebRequest request) {
		
		// String errorMessageDesc = ex.getLocalizedMessage();
		
		// if(errorMessageDesc == null) errorMessageDesc=ex.toString();
		
		// ErrorMessage errorMessage = new ErrorMessage(new Date(), ex.getLocalizedMessage());
		
		// return new ResponseEntity<>(
				// errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);		
		// }
	
}
