package com.photoapiservice.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.photoapiservice.dto.UserDto;

public class UserServiceImpl implements UserService {

	@Override
	public UserDto createUser(UserDto userDto) {

		// userDto.setUserId(UUID.randomUUID().toString());
		// Not Created because Using Model Mapper Old Method
		return null;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	
}