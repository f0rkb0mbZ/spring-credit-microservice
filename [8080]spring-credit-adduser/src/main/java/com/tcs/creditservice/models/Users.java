package com.tcs.creditservice.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
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

	public Users() {
		super();
		// TODO Auto-generated constructor stub
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

	public Date getLastPaid() {
		return lastPaid;
	}

	public void setLastPaid(Date lastPaid) {
		this.lastPaid = lastPaid;
	}

	public boolean isAlreadyFinedExceedingThresold() {
		return alreadyFinedExceedingThresold;
	}

	public void setAlreadyFinedExceedingThresold(boolean alreadyFinedExceedingThresold) {
		this.alreadyFinedExceedingThresold = alreadyFinedExceedingThresold;
	}

	public boolean isAlreadyFinedExceedingDeadline() {
		return alreadyFinedExceedingDeadline;
	}

	public void setAlreadyFinedExceedingDeadline(boolean alreadyFinedExceedingDeadline) {
		this.alreadyFinedExceedingDeadline = alreadyFinedExceedingDeadline;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", accountNo="
				+ accountNo + ", accountType=" + accountType + ", creditLimit=" + creditLimit + ", outstandingAmount="
				+ outstandingAmount + ", lastPaid=" + lastPaid + ", alreadyFinedExceedingThresold="
				+ alreadyFinedExceedingThresold + ", alreadyFinedExceedingDeadline=" + alreadyFinedExceedingDeadline
				+ "]";
	}
}