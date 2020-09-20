package com.tcs.creditservice.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.tcs.creditservice.component.AddUserComponent;
import com.tcs.creditservice.dao.UsersService;
import com.tcs.creditservice.models.Users;

@RestController
public class UsersController {
	@Autowired
	UsersService usersService;

	@Autowired
	AddUserComponent auc;

	@GetMapping("/users")
	public List<Users> getUsers() {
		return usersService.getUsers();
	}

	@GetMapping("/users/{id}")
	public Users getUsersById(@PathVariable Integer id) {
		try {
			return usersService.getUserById(id);
		} catch (NoSuchElementException e) {
			System.out.println("There is no record with id: " + id);
			e.printStackTrace();
			return null;
		}
	}

	@PutMapping("/users/{id}")
	public void updateUser(@PathVariable int id, @RequestBody Users user) {
		user = auc.setCredit(user);
		usersService.updateUser(id, user);
	}

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable Integer id) {
		try {
			usersService.deleteUser(id);
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			System.out.println("There is no record with id: " + id);
		}
	}

	@PostMapping("/users")
	public void saveUser(@RequestBody Users user) {
		user = auc.setCredit(user);
		usersService.saveUser(user);
	}
}