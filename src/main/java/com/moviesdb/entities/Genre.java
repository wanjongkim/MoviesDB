package com.moviesdb.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Genre implements Serializable{
	private static final long serialVersionUID = 1563183080194610215L;
	@Id @GeneratedValue
	private Integer id;
	private String type;
	
	public Genre() {}
	
	public Genre(String type) {
		this.type = type;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
