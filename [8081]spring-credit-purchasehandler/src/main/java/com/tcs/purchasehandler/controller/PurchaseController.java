package com.tcs.purchasehandler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

import com.tcs.purchasehandler.entity.Purchase;
import com.tcs.purchasehandler.service.PurchaseService;

@RestController
public class PurchaseController {

    @Autowired
    PurchaseService purchaseService;

    @PostMapping("/users/{id}/addpurchase")
    public void addPurchase(@PathVariable Integer id, @RequestBody Purchase purchase) {
        try {
            purchaseService.addPurchase(id, purchase);
        } catch (NoSuchElementException e) {
            System.out.println("There is no user with id: " + id);
            e.printStackTrace();
        }
    }

    @DeleteMapping("/users/{id}/deletepurchase/{purchase_id}")
    public void deletePurchase(@PathVariable Integer id, @PathVariable Integer purchase_id) {
        purchaseService.deletePurchase(id, purchase_id);
    }
}
