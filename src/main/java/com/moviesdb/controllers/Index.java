package com.moviesdb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Index {
	
	@RequestMapping("/index")
	public String indexPage() {
		//get all the movies from the 
		//ModelAndView mv = new ModelAndView();
		return "index";
	}
}
