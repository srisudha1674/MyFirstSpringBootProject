package com.web.application.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SearchCriteria {
	
	private String id;
	private String name;
	private String description;
	private String duration;
	private Integer fee;

}
