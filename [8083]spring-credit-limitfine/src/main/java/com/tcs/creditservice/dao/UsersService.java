package com.tcs.creditservice.dao;

import com.tcs.creditservice.models.Users;
import com.tcs.creditservice.repository.UsersRepository;


import java.util.function.BiPredicate;
import java.util.function.DoubleFunction;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
	@Autowired
	UsersRepository usersRepository;
	
	public void updateFine() {
		Iterable<Users> users= usersRepository.findAll();
		
		BiPredicate<Double,Double> p1=(a,b)->a >= 0.98*b;
		DoubleFunction<Double> f2=y->y*1.05;
		
		
		
		users.forEach(user->{
			if(p1.test(user.getOutstandingAmount(),user.getCreditLimit()) && !(user.isAlreadyFinedExceedingThresold()))
			{
				// System.out.println("outstanding 98% of creditLimit");
				user.setOutstandingAmount(f2.apply(user.getOutstandingAmount()));
				user.setAlreadyFinedExceedingThresold(true);
				usersRepository.save(user);
			}
		}
		);
		
		
		
	}
}
