package com.nkhurshid.services;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.nkhurshid.models.BankAccount;
import com.nkhurshid.models.SavingsAccount;

public interface SavingsAccountService {
	
	public BankAccount addSavingsAccount(SavingsAccount account);
	public List<BankAccount> findAllSavingsBankAccountsByCustomerId(int customerId);
	public int updateGiftFlag(long accountNo, double amount); 
	
}
