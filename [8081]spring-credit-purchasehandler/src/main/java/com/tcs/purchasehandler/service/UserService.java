package com.tcs.purchasehandler.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.tcs.purchasehandler.entity.Users;
import com.tcs.purchasehandler.repository.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    UsersRepository usersRepository;

    public List<Users> getAllUsers() {
        return StreamSupport.stream(usersRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }
    
    public Users getUserById(Integer id) {
        return usersRepository.findById(id).orElse(null);
    }

    public void createUser(Users user) {
        usersRepository.save(user);
    }

    public void updateUser(Integer id, Users user) {
        Users usr = this.getUserById(id);
        if (usr != null) {
            user.setId(id);
            usersRepository.save(user);
        }
    }

    public void deleteUser(Integer id) {
        usersRepository.deleteById(id);
    }

    
}
