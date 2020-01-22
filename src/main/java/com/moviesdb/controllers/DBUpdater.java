package com.moviesdb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.moviesdb.services.MoviesUpdater;

@RequestMapping("/update")
@Controller
public class DBUpdater {
	
	@Autowired
	MoviesUpdater updater;
	
	@RequestMapping("/playing")
	@ResponseBody
	public String updatePlaying() {
		updater.updatePlaying();
		return "Success";
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public String deleteAllTables() {
		updater.deleteAllTables();
		return "Success";
	}
}
