package com.example.restservice;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.example.restservice.model.AccountResponse;
import com.example.restservice.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
	public List<Transaction> getStatement(@PathVariable String accountNumber,
										  @RequestParam(value="startDate") String startDate,
										  @RequestParam(value="endDate") String endDate,
										  @RequestParam(value="txType", required = false) TxType txType
			) {
			
		return accountService.getStatement(accountNumber,startDate,endDate,txType);
	}

	@PostMapping("/transaction")
	public void saveTransaction(@RequestBody Transaction transaction) {
		accountService.saveTransaction(transaction);
	}
}
