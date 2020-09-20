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

	public List<Users> getUsers() {
		return StreamSupport.stream(usersRepository.findAll().spliterator(), false).collect(Collectors.toList());
	}

	public Users getUserById(int id) {
		return usersRepository.findById(id).orElse(null);
	}

	public void updateUser(int id, Users u) {
		Users u1 = getUserById(id);
		if (u1 != null) {
			u.setId(id);
			usersRepository.save(u);
		}
	}

	public void deleteUser(int id) {
		usersRepository.deleteById(id);
	}

	public void saveUser(Users user) {
		usersRepository.save(user);
	}
}
