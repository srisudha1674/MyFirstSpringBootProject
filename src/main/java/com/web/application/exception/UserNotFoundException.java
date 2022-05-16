package com.web.application.exception;

import com.web.application.model.ErrorBean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserNotFoundException extends RuntimeException {
	
	private ErrorBean errorBean;

}
