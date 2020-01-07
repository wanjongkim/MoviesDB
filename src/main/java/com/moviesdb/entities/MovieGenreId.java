package com.moviesdb.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class MovieGenreId implements Serializable {
	@ManyToOne
	@JoinColumn(name="MoviesId", referencedColumnName="id", foreignKey = @ForeignKey(name="MoviesId"))
	private Movies moviesId;
	@ManyToOne
	@JoinColumn(name="GenreId", referencedColumnName="id", foreignKey = @ForeignKey(name="GenreId"))
	private Genre genreId;
	
	public MovieGenreId() {}
	
	public MovieGenreId(Movies moviesId, Genre genreId) {
		this.moviesId = moviesId;
		this.genreId = genreId;
	}
	
	public Movies getMoviesId() {
		return moviesId;
	}

	public void setMoviesId(Movies moviesId) {
		this.moviesId = moviesId;
	}

	public Genre getGenreId() {
		return genreId;
	}

	public void setGenreId(Genre genreId) {
		this.genreId = genreId;
	}
}
