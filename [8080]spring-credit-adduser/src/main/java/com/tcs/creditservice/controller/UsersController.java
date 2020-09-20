package com.tcs.creditservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.tcs.creditservice.component.addUserComponent;
import com.tcs.creditservice.dao.UsersService;
import com.tcs.creditservice.models.Users;

@RestController
public class UsersController {
	@Autowired
	UsersService usersService;

	@Autowired
	addUserComponent auc;

	@GetMapping("/users")
	public List<Users> getUsers() {
		return usersService.getUsers();
	}

	@GetMapping("/users/{id}")
	public Users getUsersById(@PathVariable Integer id) {
		return usersService.getUserById(id);
	}

	@PutMapping("/users/{id}")
	public void updateUser(@PathVariable int id,@RequestBody Users user) {
		user = auc.setCredit(user);
		usersService.updateUser(id,user);
	}

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable Integer id) {
		usersService.deleteUser(id);
	}

	@PostMapping("/users")
	public void saveUser(@RequestBody Users user) {
		user = auc.setCredit(user);
		// System.out.println(user.getAccountType() + user.getCreditLimit());
		usersService.saveUser(user);
	}
}