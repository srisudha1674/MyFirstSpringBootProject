package com.web.application.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorBean {
	
	private int errorCode;
	private String errorMessage;
	

}
