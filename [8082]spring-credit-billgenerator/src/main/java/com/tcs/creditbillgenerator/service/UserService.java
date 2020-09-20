package com.tcs.creditbillgenerator.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.tcs.creditbillgenerator.entity.Purchase;
import com.tcs.creditbillgenerator.entity.Users;
import com.tcs.creditbillgenerator.repository.PurchaseRepository;
import com.tcs.creditbillgenerator.repository.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    UsersRepository usersRepository;

    @Autowired
    PurchaseRepository purchaseRepository;

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

    public void addPurchase(Integer id, Purchase purchase) {
        Users userFromDB = this.getUserById(id);
        userFromDB.setOutstandingAmount(userFromDB.getOutstandingAmount() + purchase.getPrice());
        purchase.setUser(userFromDB);
        purchaseRepository.save(purchase);
    }

    public void deletePurchase(Integer id, Integer purchase_id) {
        Users userFromDB = this.getUserById(id);
        Purchase purchaseFromDB = purchaseRepository.findById(id).orElse(null);
        userFromDB.setOutstandingAmount(userFromDB.getOutstandingAmount() + purchaseFromDB.getPrice());
        userFromDB.removePurchase(purchaseFromDB);
        purchaseRepository.deleteById(purchase_id);
    }
}
