package com.moviesdb.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

public class MovieId {
	private Integer id;
	private String title;
 
	public MovieId() {}
	
	public MovieId(Integer id, String title) {
		this.id = id;
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
