package com.photoapiservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.photoapiservice.model.CreateUser;

@RestController
@RequestMapping("/users")
public class UsersController {
	@Autowired
	private Environment env;
	
	@GetMapping("/status/check")
	public String status() {
		return "User Call";
	}
	
	@PostMapping
	public String createUser(@RequestBody CreateUser userDetails) {
		return "Created API User Call";
	}
	
}