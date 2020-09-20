package com.tcs.purchasehandler.repository;

import com.tcs.purchasehandler.entity.Purchase;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends CrudRepository<Purchase, Integer> {
    
}
