package com.web.application.controller;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.web.application.exception.DBConnectionException;
import com.web.application.exception.RecordNotFoundException;
import com.web.application.model.ErrorBean;

@RestControllerAdvice
@Order(1)
public class ExceptionController {
	
	@ExceptionHandler(value= RecordNotFoundException.class)
	public final ResponseEntity<ErrorBean>exception(RecordNotFoundException e)
	{
		return new ResponseEntity<>(e.getErrorBean(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value= DBConnectionException.class)
	public final ResponseEntity<ErrorBean>exception(DBConnectionException e)
	{
		return new ResponseEntity<>(e.getErrorBean(),HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
