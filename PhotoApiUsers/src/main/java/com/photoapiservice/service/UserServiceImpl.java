package com.photoapiservice.service;

import java.util.Optional;
import java.util.UUID;

import com.photoapiservice.dto.UserDto;

public class UserServiceImpl implements UserService {

	@Override
	public UserDto createUser(UserDto userDto) {

		// userDto.setUserId(UUID.randomUUID().toString());
		// Not Created because Using Model Mapper Old Method
		return null;
	}

	@Override
	public <S extends UserDto> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends UserDto> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<UserDto> findById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<UserDto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<UserDto> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UserDto entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends UserDto> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}
	
}