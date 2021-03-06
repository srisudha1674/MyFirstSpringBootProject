package com.web.application.controller;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;



@Entity
@Table(name = "TOPIC")
@Getter
@Setter
@AllArgsConstructor


public class Topic {
	
	@JsonIgnore
	@Id
	@Column(name = "ID")
	private String id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name ="DURATION")
	private String duration;
	@Column(name = "FEE")
	private int fee;
	@LastModifiedDate
	@Column(name = "LASTMODIFIED_TIME")
	private Date lastModified;
	
	@OneToOne(fetch=FetchType.LAZY)
	@Fetch(value=FetchMode.SELECT)
	@JoinColumn(name="ID")
	private Inst inst;
	
	public Topic() {
	}
	
	public Topic(String id, String name, String description, String duration, int fee) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.duration = duration;
		this.fee = fee;
	}

	public Topic(String id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	
		

}
