package com.noah.capstone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/empStatus")
public class WebController {
	
	@RequestMapping(path = "/index")
	public String index() {
		return "index";
	}

}
