package com.moviesdb.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class VideoId implements Serializable {
	private static final long serialVersionUID = -7837553967278045018L;
	@Column(name="Path")
	private String path;
	@ManyToOne
	@JoinColumn(name = "MoviesId", referencedColumnName = "id", foreignKey = @ForeignKey(name="videos_ibfk_1"))
	private Movies movie;
	
	public VideoId() {}
	
	public VideoId(String path, Movies movie) {
		this.path = path;
		this.movie = movie;
	}
	
	public VideoId(String path) {
		this.path = path;
	}
	
	public String getPath() {
		return path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
}