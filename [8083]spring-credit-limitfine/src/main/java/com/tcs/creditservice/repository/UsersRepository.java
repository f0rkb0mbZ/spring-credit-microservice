package com.tcs.creditservice.repository;

import org.springframework.data.repository.CrudRepository;  
import com.tcs.creditservice.models.Users;  
public interface UsersRepository extends CrudRepository<Users, Integer>  
{  
}  