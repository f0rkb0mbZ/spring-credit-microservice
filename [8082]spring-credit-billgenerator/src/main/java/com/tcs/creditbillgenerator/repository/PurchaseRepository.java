package com.tcs.creditbillgenerator.repository;

import com.tcs.creditbillgenerator.entity.Purchase;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends CrudRepository<Purchase, Integer> {
    
}
