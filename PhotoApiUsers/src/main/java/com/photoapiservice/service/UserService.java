package com.photoapiservice.service;

import org.springframework.data.repository.CrudRepository;

import com.photoapiservice.dto.UserDto;


public interface UserService extends CrudRepository<UserSer, Long> {
	UserDto createUser(UserDto userDto);
}