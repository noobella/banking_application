package com.nkhurshid.services;

import java.util.List;
import java.util.Optional;

import com.nkhurshid.models.BankAccount;

public interface BankAccountService {
	
	public List<BankAccount> findAllBankAccountByCustomerId(int customerId);
	public Optional<BankAccount> findBankAccountByAccountNo(long accountNo);
	public int deposit(BankAccount account, double amount) throws GiftCheckpointException;
	public int withdraw(BankAccount account, double amount) throws LimitExceededException;
	
}
