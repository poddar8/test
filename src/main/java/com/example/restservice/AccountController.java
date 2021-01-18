package com.example.restservice;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	public enum TxType {
	    DEPOSIT, WITHDRAWAL;
	}
	
	@Autowired  
	AccountService accountService;  

	@GetMapping("/account/{accountNumber}/balance")
	public AccountResponse getAccountBalance(@PathVariable String accountNumber) {
		return accountService.getAccountByaccountNumber(accountNumber);
	}
	
	@GetMapping("/account/{accountNumber}/statement")
	public List<TransactionResponse> getStatement(@PathVariable String accountNumber,
			@RequestParam(value="startDate") String startDate, 
			@RequestParam(value="endDate") String endDate,
			@RequestParam(value="txType", required = false) TxType txType
			) {
			
		return accountService.getStatement(accountNumber,startDate,endDate,txType);
	}	
}
