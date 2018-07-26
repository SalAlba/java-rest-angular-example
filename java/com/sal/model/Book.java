package com.sal.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Book {

	// fields ...
	private long id;
	private String name;
	private String type;
	private Date crated;
	
	// constructor ...
	public Book(){}
	
	public Book(long id, String name, String type) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.crated = new Date();
	}

	// get/set ...
	
	public long getId() { return id; }
	public void setId(long id) { this.id = id; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getType() { return type; }
	public void setType(String type) { this.type = type; }
	public Date getCrated() { return crated; }
	public void setCrated(Date crated) { this.crated = crated; }

	
}
