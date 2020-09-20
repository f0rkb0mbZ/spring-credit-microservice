package com.tcs.purchasehandler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

import com.tcs.purchasehandler.entity.Purchase;
import com.tcs.purchasehandler.entity.Users;
import com.tcs.purchasehandler.repository.PurchaseRepository;

@Service
public class PurchaseService {

    @Autowired
    PurchaseRepository purchaseRepository;

    @Autowired
    UserService userService;

    public void addPurchase(Integer id, Purchase purchase) {
        Users userFromDB = userService.getUserById(id);
        userFromDB.setOutstandingAmount(userFromDB.getOutstandingAmount() + purchase.getPrice());
        purchase.setUser(userFromDB);
        purchaseRepository.save(purchase);
    }

    public void deletePurchase(Integer id, Integer purchase_id) {
        try {
            Users userFromDB = userService.getUserById(id);
            try {
                Purchase purchaseFromDB = purchaseRepository.findById(id).get();
                userFromDB.setOutstandingAmount(userFromDB.getOutstandingAmount() - purchaseFromDB.getPrice());
                userFromDB.removePurchase(purchaseFromDB);
                purchaseRepository.deleteById(purchase_id);
            } catch (NoSuchElementException e) {
                System.out.println("There is no purchase with id: " + id);
                e.printStackTrace();
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            System.out.println("There is no user with id: " + id);
        }

    }
}