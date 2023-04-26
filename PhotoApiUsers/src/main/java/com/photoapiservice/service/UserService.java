package com.photoapiservice.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.photoapiservice.dto.UserDto;


public interface UserService extends UserDetailsService {
	UserDto createUser(UserDto userDto);
}