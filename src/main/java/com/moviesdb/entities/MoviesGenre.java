package com.moviesdb.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="moviesgenre")
public class MoviesGenre {
	@EmbeddedId
	private MovieGenreId id;

	public MoviesGenre() {}
	
	public MoviesGenre(MovieGenreId id) {
		this.id = id;
	}
	
	public MovieGenreId getId() {
		return id;
	}

	public void setId(MovieGenreId id) {
		this.id = id;
	}
	
}
