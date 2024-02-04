package com.firstproject.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Homecontroller {
	
	// this is for checking purpose
	
	@ResponseBody
	@GetMapping("/")
	public String home() {
		return "welcome to springboot project using JSP";
				
	}
	 
	// API for creating the details
	@PostMapping("/savedata")
	public String savedata() {
		
		return "Data saved successfully!!!";
				
	}

}

