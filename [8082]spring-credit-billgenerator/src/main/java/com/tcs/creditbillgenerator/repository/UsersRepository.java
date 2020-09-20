package com.tcs.creditbillgenerator.repository;

import com.tcs.creditbillgenerator.entity.Users;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<Users, Integer> {
    
}
