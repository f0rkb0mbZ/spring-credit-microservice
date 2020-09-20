package com.tcs.creditservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.tcs.creditservice.models.Users;

public interface UserRepository extends CrudRepository<Users, Integer> {

}
