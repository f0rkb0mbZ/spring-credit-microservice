package com.tcs.creditservice.component;

import org.springframework.stereotype.Component;

import com.tcs.creditservice.models.Users;

@Component
public class addUserComponent {
		
	public Users setCredit(Users u) {
		if (u.getAccountType().equals("basic")) {
			u.setCreditLimit(10000);
		}
		else if (u.getAccountType().equals("silver")) {
			u.setCreditLimit(20000);
		}
		else if (u.getAccountType().equals("gold")) {
			u.setCreditLimit(50000);
		}
		else if (u.getAccountType().equals("platinum")) {
			u.setCreditLimit(100000);
		}
		else {
			u.setCreditLimit(0);
		}
		u.setOutstandingAmount(0.0);
		return u;
	}

}
