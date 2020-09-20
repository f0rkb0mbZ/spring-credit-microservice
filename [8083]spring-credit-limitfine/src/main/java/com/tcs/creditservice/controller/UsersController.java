package com.tcs.creditservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import com.tcs.creditservice.dao.UsersService;

@RestController
public class UsersController {
    @Autowired
    UsersService usersService;

    @PutMapping(value = "/applylimitfine")
    public Map<String, String> getUsers() {
        usersService.updateFine();
        Map<String, String> message = new HashMap<>();
        message.put("message", "Fine is applied to the defaulters");
        return message;
    }
}