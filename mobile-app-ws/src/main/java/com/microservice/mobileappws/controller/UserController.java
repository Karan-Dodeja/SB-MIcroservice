package com.microservice.mobileappws.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.print.attribute.standard.Media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.mobileappws.exceptions.UserServiceException;
import com.microservice.mobileappws.model.UserDetailsRequestModel;
import com.microservice.mobileappws.model.UserRest;
import com.microservice.mobileappws.model.updteUserDetailsRequestModel;
import com.microservice.mobileappws.service.UserService;
import com.microservice.mobileappws.service.UserServiceImp;

@RestController
@RequestMapping("/users") //http://localhost:8080/users
public class UserController {

	Map<String, UserRest> users;
	
	@Autowired
	UserService userService;
	
	@GetMapping()
	public String getuUsers(@RequestParam(value="page", required = false) int page, @RequestParam(value="limit") int limit) {
		return "get user called"+ page + limit;
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<UserRest> getuUser(@PathVariable String id) {

		if(true) throw new UserServiceException("A User Service Exception Is Thrown.");
		
		if(users.containsKey(id)) {
			return new ResponseEntity<UserRest>(users.get(id), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		// return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
	}
	
	@PostMapping(consumes = {
			MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE
	}, produces = {
			MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE
	} )
	public ResponseEntity<UserRest> createUser(@RequestBody UserDetailsRequestModel userdetails) {
		UserRest returnValue = userService.createUser(userdetails);
		return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
	}
	
	@PutMapping(path="/{id}", consumes = {
			MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE
	}, produces = {
			MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE
	} )
	public UserRest updateUser(@PathVariable String id, @RequestBody updteUserDetailsRequestModel userdetails) {
		UserRest storedUserDetails = users.get(id);
		storedUserDetails.setFirstName(userdetails.getFirstName());
		storedUserDetails.setLastName(userdetails.getLastName());
		users.put(id, storedUserDetails);
		return storedUserDetails;
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable String id) {
		users.remove(id);
		return ResponseEntity.noContent().build();
	}
	
}