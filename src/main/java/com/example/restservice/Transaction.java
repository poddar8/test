package com.example.restservice;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table  
@Entity
public class Transaction {

	@Id  
	@Column  
	private String accountNumber; 
	
	@Temporal(TemporalType.TIMESTAMP)  
	private Date transactionTs; 
	
	@Column  
	private String type;
	
	@Column  
	private double amount;

	public double getAmount() {
		return amount;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public Date getTransactionTs() {
		return transactionTs;
	}

	public String getType() {
		return type;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setTransactionTs(Date transactionTs) {
		this.transactionTs = transactionTs;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	

	

}
