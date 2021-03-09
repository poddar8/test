package com.example.restservice;

import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, String> {
	
	Account findTopByAccountNumberOrderByLastUpdateTimestampDesc(String accountNumber);
	
	
}