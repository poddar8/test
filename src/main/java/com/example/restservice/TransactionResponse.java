package com.example.restservice;

import java.util.Date;

public class TransactionResponse {
	
	private String accountNumber; 
	
	private Date transactionTs;
	
	private String transactionType;
	
	private double amount;
	
	public TransactionResponse(String accountNumber, Date transactionTS, String transactionType, double amount) {
		this.accountNumber = accountNumber;
		this.transactionTs = transactionTS;
		this.transactionType = transactionType;
		this.amount = amount;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setTransactionTs(Date transactionTs) {
		this.transactionTs = transactionTs;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public Date getTransactionTs() {
		return transactionTs;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public double getAmount() {
		return amount;
	}

}
