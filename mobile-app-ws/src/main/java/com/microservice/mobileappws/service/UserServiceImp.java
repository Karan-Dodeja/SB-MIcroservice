package com.microservice.mobileappws.service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.microservice.mobileappws.model.UserDetailsRequestModel;
import com.microservice.mobileappws.model.UserRest;

@Service
public class UserServiceImp implements UserService {

	Map<String, UserRest> users;
	
	@Override
	public UserRest createUser(UserDetailsRequestModel userDetails) {
		UserRest returnValue = new UserRest();
		returnValue.setEmail(userDetails.getEmail());
		returnValue.setFirstName(userDetails.getFirstname());
		returnValue.setLastName(userDetails.getLastName());
		
		String userId = UUID.randomUUID().toString();
		returnValue.setUserId(userId);
		
		if(users==null) users = new HashMap<>();
		users.put(userId, returnValue);
		
		return returnValue;
	}
	
}
