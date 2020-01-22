package com.moviesdb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.moviesdb.PageInfo.MovieInfo;
import com.moviesdb.services.PageService;

@Controller
public class Index {
	@Autowired
	PageService ps;
	
	@RequestMapping("/index")
	public ModelAndView indexPage() {
		//get all the movies from the 
		ModelAndView mv = new ModelAndView();
		List<MovieInfo> infos = ps.getPlaying();
		mv.addObject("movies", infos);
		mv.setViewName("index");
		return mv;
	}
}
