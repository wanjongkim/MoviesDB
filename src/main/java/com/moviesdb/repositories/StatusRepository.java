package com.moviesdb.repositories;

import org.springframework.data.repository.CrudRepository;

import com.moviesdb.entities.Status;

public interface StatusRepository extends CrudRepository<Status, Integer> {
	Status findByStatus(String stat);
}
