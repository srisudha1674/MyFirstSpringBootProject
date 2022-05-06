package com.web.application.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController		
public class APIController {
	
	@RequestMapping("/hello")
	public String sayHi()
	{
		return "Hi";
	}


}
