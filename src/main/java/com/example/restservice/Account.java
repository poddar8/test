package com.example.restservice;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;


@Table  
@Entity
@Getter
//@NamedQuery(name = "Account.findByAccountNumberOrderBylastUpdateTimestampDesc" ,
//			query = "select top 1 a from Account a where a.accountNumber= :accountNumber order by lastUpdateTimestamp desc")
public class Account {
	
	@Id  
	@Column  
	protected int id; 
	
	@Column  
	protected String accountNumber; 
	
	@Temporal(TemporalType.TIMESTAMP)  
	protected Date lastUpdateTimestamp;
	
	@Column  
	protected double balance;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Date getLastUpdateTimestamp() {
		return lastUpdateTimestamp;
	}

	public void setLastUpdateTimestamp(Date lastUpdateTimestamp) {
		this.lastUpdateTimestamp = lastUpdateTimestamp;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}
