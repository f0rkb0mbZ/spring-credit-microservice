package com.tcs.creditbillgenerator.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import com.tcs.creditbillgenerator.entity.Users;
import com.tcs.creditbillgenerator.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillController {

	private Map<Object, Object> billMaker(Users user) {
		Map<Object, Object> bill = new HashMap<>();
		bill.put("user_id", user.getId());
		bill.put("name", user.getName());
		bill.put("credit_limit", user.getCreditLimit());
		bill.put("outstanding_amount", user.getOutstandingAmount());
		bill.put("minumum_due", Math.round(user.getOutstandingAmount() * 0.025 * 100) / 100.0);
		bill.put("spends", user.getPurchases());
		return bill;
	}

	@Autowired
	public UserService userService;

	@GetMapping("/users/{id}/getbill")
	public Map<Object, Object> generateBillByUser(@PathVariable Integer id) {
		try {
			Users user = userService.getUserById(id);
			return this.billMaker(user);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			System.out.println("There is no user with id: " + id);
			return null;
		}
	}

	@GetMapping("/users/getbills")
	public List<Map<Object, Object>> generateBillsOfAllUsers() {
		List<Map<Object, Object>> bills = userService.getAllUsers().stream().map(user -> this.billMaker(user))
				.collect(Collectors.toList());
		return bills;
	}

}
