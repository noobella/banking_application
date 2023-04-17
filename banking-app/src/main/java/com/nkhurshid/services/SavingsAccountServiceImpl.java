package com.nkhurshid.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nkhurshid.models.BankAccount;
import com.nkhurshid.models.SavingsAccount;
import com.nkhurshid.respositories.SavingsAccountRepository;

@Service
public class SavingsAccountServiceImpl implements SavingsAccountService {

	@Autowired
	private SavingsAccountRepository savingsAccountRepository;
	
	@Override
	public BankAccount addSavingsAccount(SavingsAccount account) {
		return savingsAccountRepository.save(account);
	}
	
	@Override
	public List<BankAccount> findAllSavingsBankAccountsByCustomerId(int customerId) {
		return savingsAccountRepository.findAllSavingsBankAccountsByCustomerId(customerId);
	}
	
	@Override
	public int updateGiftFlag(long accountNo, double amount) {
		return savingsAccountRepository.updateGiftFlag(accountNo, amount);
	}

}
