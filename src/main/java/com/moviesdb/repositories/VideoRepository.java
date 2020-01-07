package com.moviesdb.repositories;

import org.springframework.data.repository.CrudRepository;

import com.moviesdb.entities.Videos;
import com.moviesdb.entities.VideoId;

public interface VideoRepository extends CrudRepository<Videos, VideoId>{
	
}