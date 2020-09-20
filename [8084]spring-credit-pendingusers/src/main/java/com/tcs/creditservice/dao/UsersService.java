package com.tcs.creditservice.dao;

import com.tcs.creditservice.models.Users;
import com.tcs.creditservice.repository.UsersRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
	@Autowired
	UsersRepository usersRepository;
	
	
	public List<Users> getUsersWithOutstanding() {
		List<Users> u= StreamSupport.stream(usersRepository.getAllUsers().spliterator(), false).collect(Collectors.toList());
		return u;
	}
}
