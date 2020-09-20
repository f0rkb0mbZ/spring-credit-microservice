package com.tcs.purchasehandler.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column
    private String name;
    
    @Column
    private String email;
    
    @Column
    private String phone;
    
    @Column
    private String accountNo;
    
    @Column
    private String accountType;
    
    @Column
    private double creditLimit;
    
    @Column
    private double outstandingAmount;

    @Column
    private Date lastPaid;
    
    @Column
	@JsonIgnore
	private boolean alreadyFinedExceedingThresold=false;
	
	@Column
	@JsonIgnore
	private boolean alreadyFinedExceedingDeadline=false;

    @OneToMany(targetEntity = Purchase.class, mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("user")
    private List<Purchase> purchases = new ArrayList<Purchase>();

    public void addPurchase(Purchase purchase) {
        purchases.add(purchase);
        purchase.setUser(this);
    }

    public void removePurchase(Purchase purchase) {
        purchases.remove(purchase);
        purchase.setUser(null);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public double getOutstandingAmount() {
        return outstandingAmount;
    }

    public void setOutstandingAmount(double outstandingAmount) {
        this.outstandingAmount = outstandingAmount;
    }

    public Date getLastpaid() {
        return lastPaid;
    }

    public void setLastpaid(Date lastpaid) {
        this.lastPaid = lastpaid;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }

    // public Users(int id, String name, String email, String phone, String accountNo, String accountType,
    //         double creditLimit, double outstandingAmount, Date lastpaid) {
    //     this.id = id;
    //     this.name = name;
    //     this.email = email;
    //     this.phone = phone;
    //     this.accountNo = accountNo;
    //     this.accountType = accountType;
    //     this.creditLimit = creditLimit;
    //     this.outstandingAmount = outstandingAmount;
    //     this.lastpaid = lastpaid;
    // }

    @Override
    public String toString() {
        return "Users [accountNo=" + accountNo + ", accountType=" + accountType + ", creditLimit=" + creditLimit
                + ", email=" + email + ", id=" + id + ", lastpaid=" + lastPaid + ", name=" + name
                + ", outstandingAmount=" + outstandingAmount + ", phone=" + phone + "]";
    }

}
