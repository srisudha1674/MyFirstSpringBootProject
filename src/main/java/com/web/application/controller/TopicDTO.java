package com.web.application.controller;

import java.io.Serializable;

public class TopicDTO implements Serializable{

	private String id;
	private String name;
	private String description;
	private String teacher;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public TopicDTO(String id, String name, String description, String teacher) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.teacher = teacher;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public TopicDTO(String id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
}
