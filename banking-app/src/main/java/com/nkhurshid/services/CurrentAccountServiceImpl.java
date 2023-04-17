package com.nkhurshid.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nkhurshid.models.BankAccount;
import com.nkhurshid.models.CurrentAccount;
import com.nkhurshid.respositories.CurrentAccountRepository;

@Service
public class CurrentAccountServiceImpl implements CurrentAccountService {

	@Autowired
	private CurrentAccountRepository currentAccountRepository;
	
	@Override
	public BankAccount addCurrentAccount(CurrentAccount account) {
		return currentAccountRepository.save(account);
	}
	
	@Override
	public List<BankAccount> findAllCurrentBankAccountsByCustomerId(int customerId) {
		return currentAccountRepository.findAllCurrentBankAccountsByCustomerId(customerId);
	}

}
