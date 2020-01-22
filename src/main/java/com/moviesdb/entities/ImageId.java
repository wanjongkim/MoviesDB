package com.moviesdb.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ImageId implements Serializable {
	private static final long serialVersionUID = -852838117059764880L;
	@Column(name="path")
	private String path;
	@ManyToOne
	@JoinColumn(name="mid", referencedColumnName="id", foreignKey = @ForeignKey(name="images_ibfk_1"))
	private Movies movie;
	
	public ImageId() {}
	
	public ImageId(String path, Movies movie) {
		this.path = path;
		this.setMovie(movie);
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}

	public Movies getMovie() {
		return movie;
	}

	public void setMovie(Movies movie) {
		this.movie = movie;
	}
}