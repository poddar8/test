package com.example.restservice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.example.restservice.model.AccountResponse;
import com.example.restservice.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.restservice.AccountController.TxType;

@Service
public class AccountService {

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	TransactionRepository transactionRepository;

	// getting a specific record
	public AccountResponse getAccountByaccountNumber(String accountNumber) {
		final Account account = accountRepository.findTopByAccountNumberOrderByLastUpdateTimestampDesc(accountNumber);
		final AccountResponse response = translateAccount(account);
		return response;
	}

	private AccountResponse translateAccount(Account account) {
		AccountResponse accountResp = new AccountResponse();
		accountResp.setAccountNumber(account.getAccountNumber());
		accountResp.setBalance(account.getBalance());
		accountResp.setLastUpdateTimestamp(account.getLastUpdateTimestamp());
		return accountResp;
	}



	public List<Transaction> getStatement(String accountNumber, String startDate, String endDate,
										  TxType txType) {
		Date startDateTime = null;
		Date endDateTime = null;
		try {
			startDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(startDate);
			endDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(endDate);
		} catch (ParseException e) {
		}
		List<com.example.restservice.Transaction> transaction = null;
		if (StringUtils.isEmpty(txType.toString())) {

			transaction = transactionRepository.findByTransaction(accountNumber, startDateTime, endDateTime);
		} else {
			transaction = transactionRepository.findByTransactionByType(accountNumber, startDateTime, endDateTime,
					txType.toString());
		}

		final List<Transaction> response = translateTransaction(transaction);
		return response;
	}

	private List<Transaction> translateTransaction(List<com.example.restservice.Transaction> transaction) {

		final List<Transaction> listTransactionResponse = transaction.stream()
				.map(tx -> new Transaction(tx.getAccountNumber(), tx.getTransactionTs(), tx.getType(),
						tx.getAmount()))
				.collect(Collectors.toList());

		return listTransactionResponse;
	}

	public void saveTransaction(Transaction transaction) {
		com.example.restservice.Transaction tx = new com.example.restservice.Transaction();
		tx.setAccountNumber(transaction.getAccountNumber());
		tx.setTransactionTs(transaction.getTransactionTs());
		tx.setAmount(transaction.getAmount());
		tx.setType(transaction.getTransactionType());
		transactionRepository.save(tx);
	}
}
