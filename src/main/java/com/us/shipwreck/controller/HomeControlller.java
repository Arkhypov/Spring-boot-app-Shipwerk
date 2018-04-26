package com.us.shipwreck.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@EnableAutoConfiguration
public class HomeControlller {
	
	@RequestMapping("/")
	public String home(){
		
		return "Hello at home";
	}
	
	

}
