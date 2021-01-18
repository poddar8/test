package com.example.restservice;

import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, String> {
	
	Account findTopByAccountNumberOrderByLastUpdateTimestampDesc(String accountNumber);
	
	
}