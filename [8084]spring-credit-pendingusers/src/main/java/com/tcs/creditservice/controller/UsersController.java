package com.tcs.creditservice.controller;
/*
1) Create a microservice to add new users and assign credit limit. The credit limit should different for different users.
2) Create a microservice to make some purchases for a user. shushendu
3) Create a microservice to generate bill for each user. Microservice should give details of spends, 
credit limit, outstanding amount and minimum due (minimum due should be 2.5% of outstanding). snehagshu
4) Create a microservice to apply fine of 5% for users whose outstanding 98% of the credit limit. prashant
5) Create a microservice to give the list of users whose outstanding is pending from 60 days. jinam
6) Create a microservice to add 4.2% to the outstanding amount if the bill is not paid for 60 days. sarath

*SELECT datediff(month,convert('15-10-2015USERS USERS USERS USERS ',daTE ),convert('15-10-2017',date))
*/

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.creditservice.dao.UsersService;
import com.tcs.creditservice.models.Users;

 
@RestController
public class UsersController {
	@Autowired
	UsersService usersService;


@GetMapping("/notpaidusers")
	public List<Users> getUser() {
		List<Users> users=usersService.getUsersWithOutstanding();
		return users;
	}
}