package com.tcs.creditservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.tcs.creditservice.models.Users;

public interface UsersRepository extends CrudRepository<Users, Integer> {
	
	@Query(value = "select * from Users u where DATEDIFF(day,u.lastPaid,current_date()) >=60 and u.outstandingAmount>0",nativeQuery = true)
	public List<Users> getAllUsers();
}