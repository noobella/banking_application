package com.nkhurshid.services;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.nkhurshid.models.BankAccount;
import com.nkhurshid.models.CurrentAccount;

public interface CurrentAccountService {
	
	public BankAccount addCurrentAccount(CurrentAccount account);
	public List<BankAccount> findAllCurrentBankAccountsByCustomerId(int customerId);

}
