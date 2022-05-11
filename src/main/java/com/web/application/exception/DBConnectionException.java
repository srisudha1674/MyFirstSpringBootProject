package com.web.application.exception;

import com.web.application.model.ErrorBean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DBConnectionException extends RuntimeException {
	
	private ErrorBean errorBean;

}
