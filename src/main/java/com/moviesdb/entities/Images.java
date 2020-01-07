package com.moviesdb.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class Images {
	@EmbeddedId
	private ImageId imageId;
	
	public Images() {}
	
	public Images(ImageId imageId) {
		this.imageId = imageId;
	}
	
	public ImageId getImageId() {
		return imageId;
	}
	
	public void setImageId(ImageId imageId) {
		this.imageId = imageId;
	}
}


