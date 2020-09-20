package com.tcs.purchasehandler.repository;

import com.tcs.purchasehandler.entity.Users;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<Users, Integer> {
    
}
