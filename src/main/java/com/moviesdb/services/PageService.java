package com.moviesdb.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.moviesdb.PageInfo.MovieInfo;
import com.moviesdb.entities.Genre;
import com.moviesdb.entities.Images;
import com.moviesdb.entities.Movies;
import com.moviesdb.entities.Videos;
import com.moviesdb.repositories.ImageRepository;
import com.moviesdb.repositories.MovieRepository;

@Service
public class PageService {
	@Autowired
	MovieRepository movieRepo;
	@Autowired
	ImageRepository imgRepo;
	
	public List<MovieInfo> getPlaying() {
		List<MovieInfo> infos = new ArrayList<>();
		for(Movies m : movieRepo.findAll()) {
			//List<Images> images = movieRepo.findSingleImage(m.getId(), PageRequest.of(0, 1));
			//List<Videos> videos = movieRepo.findAllMatchingVideos(m.getId());
			List<Genre> genres = movieRepo.findAllMatchingGenres(m.getId());
			MovieInfo info = new MovieInfo(m, genres);
			/*
			if(images.size()==1)
				info = new MovieInfo(m, images.get(0), genres);
			else
				info = new MovieInfo(m, genres);
			*/
			infos.add(info);
		}
		return infos;
	}
}
