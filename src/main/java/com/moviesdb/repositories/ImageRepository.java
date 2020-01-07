package com.moviesdb.repositories;

import org.springframework.data.repository.CrudRepository;

import com.moviesdb.entities.Images;
import com.moviesdb.entities.ImageId;

public interface ImageRepository extends CrudRepository<Images, ImageId> {

}
