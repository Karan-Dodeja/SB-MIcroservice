package com.microservice.mobileappws.service;

import com.microservice.mobileappws.model.UserDetailsRequestModel;
import com.microservice.mobileappws.model.UserRest;

public interface UserService {
	UserRest createUser(UserDetailsRequestModel userDetails); 
}