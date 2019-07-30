package com.billa.user.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.billa.user.entities.UserDetails;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins =  {"http://localhost:4200"}, maxAge = 3600)
public class UserController {
	
	@PostMapping("/demo")
	public UserDetails createUser(@RequestBody UserDetails details)
	{
		System.out.println("create user called"+details);
		return null;
	}

}
