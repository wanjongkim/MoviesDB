package com.moviesdb.PageInfo;

import java.util.List;

import com.moviesdb.entities.Genre;
import com.moviesdb.entities.Images;
import com.moviesdb.entities.Movies;
import com.moviesdb.entities.Videos;

public class MovieInfo {
	
	private Movies movie;
	private Images poster;
	private List<Genre> genres;
	private List<Videos> videos;
	private List<Images> images;
	
	public MovieInfo(Movies movie, List<Genre> genres, List<Videos> videos, List<Images> images) {
		this.movie = movie;
		this.genres = genres;
		this.videos = videos;
		this.images = images;
	}
	
	public MovieInfo(Movies movie, List<Genre> genres) {
		this.movie = movie;
		this.genres = genres;
	}

	public Movies getMovie() {
		return movie;
	}

	public void setMovie(Movies movie) {
		this.movie = movie;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	public List<Videos> getVideos() {
		return videos;
	}

	public void setVideos(List<Videos> videos) {
		this.videos = videos;
	}

	public List<Images> getImages() {
		return images;
	}

	public void setImages(List<Images> images) {
		this.images = images;
	}

	public Images getPoster() {
		return poster;
	}

	public void setPoster(Images poster) {
		this.poster = poster;
	}
}
