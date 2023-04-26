package com.photoapiservice.service;

import org.springframework.data.repository.CrudRepository;

import com.photoapiservice.dto.UserDto;

public interface UserRepository extends CrudRepository<UserDto, Long> {
	
}