package com.tcs.creditservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.creditservice.UserService.UserService;
import com.tcs.creditservice.models.Users;

@RestController
public class CreditController {

	@Autowired
	private UserService userService;

	@PutMapping("/applynotpaidfine")
	public void updateOutstandingFine() {
		userService.updateOutstandingFine();
	}

}
