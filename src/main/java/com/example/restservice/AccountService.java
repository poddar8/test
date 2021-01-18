package com.example.restservice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

	public List<TransactionResponse> getStatement(String accountNumber, String startDate, String endDate,
			TxType txType) {
		Date startDateTime = null;
		Date endDateTime = null;
		try {
			startDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(startDate);
			endDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(endDate);
		} catch (ParseException e) {
		}
		List<Transaction> transaction = null;
		if (StringUtils.isEmpty(txType.toString())) {

			transaction = transactionRepository.findByTransaction(accountNumber, startDateTime, endDateTime);
		} else {
			transaction = transactionRepository.findByTransactionByType(accountNumber, startDateTime, endDateTime,
					txType.toString());
		}

		final List<TransactionResponse> response = translateTransaction(transaction);
		return response;
	}

	private List<TransactionResponse> translateTransaction(List<Transaction> transaction) {

		final List<TransactionResponse> listTransactionResponse = transaction.stream()
				.map(tx -> new TransactionResponse(tx.getAccountNumber(), tx.getTransactionTs(), tx.getType(),
						tx.getAmount()))
				.collect(Collectors.toList());

		return listTransactionResponse;
	}

}
