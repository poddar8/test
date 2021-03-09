package com.example.restservice;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TransactionRepository extends CrudRepository<Transaction, String> {

	@Query("select a from Transaction a where a.accountNumber= :accountNumber and a.transactionTs >= :TransactionTsStart AND a.transactionTs <= :TransactionTsEnd ")
	List<Transaction> findByTransaction(@Param("accountNumber") String accountNumber, @Param("TransactionTsStart") Date TransactionTsStart,
			@Param("TransactionTsEnd") Date TransactionTsEnd);
	
	@Query("select a from Transaction a where a.accountNumber= :accountNumber and a.transactionTs >= :TransactionTsStart AND a.transactionTs <= :TransactionTsEnd AND type= :txType ")
	List<Transaction> findByTransactionByType(@Param("accountNumber") String accountNumber, @Param("TransactionTsStart") Date TransactionTsStart,
	@Param("TransactionTsEnd") Date TransactionTsEnd, @Param("txType") String txType);

}