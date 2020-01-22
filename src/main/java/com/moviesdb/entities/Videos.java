package com.moviesdb.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
@Entity
public class Videos {
	@EmbeddedId
	private VideoId videoId;
	private String name;
	
	public Videos() {}
	
	public Videos(VideoId videoId, String name) {
		this.videoId = videoId;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public VideoId getVideoId() {
		return videoId;
	}
	public void setVideoId(VideoId videoId) {
		this.videoId = videoId;
	}
}
