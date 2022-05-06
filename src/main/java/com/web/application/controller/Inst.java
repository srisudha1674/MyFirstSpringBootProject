package com.web.application.controller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "INST")
public class Inst {
	
	@Id
	@Column(name = "ID")
	private String id;
	@Column(name = "TEACHER")
	private String 	teacher;
	
	public Inst() {
		super();
	}
	public Inst(String id, String teacher) {
		super();
		this.id = id;
		this.teacher = teacher;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	

}
