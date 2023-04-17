package com.nkhurshid.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Git;
import org.springframework.stereotype.Service;

import com.nkhurshid.models.BankAccount;
import com.nkhurshid.models.CurrentAccount;
import com.nkhurshid.models.SavingsAccount;
import com.nkhurshid.respositories.BankAccountRepository;

@Service
public class BankAccountServiceImpl implements BankAccountService {

	@Autowired
	private BankAccountRepository bankAccountRepository;
	@Autowired
	private CurrentAccountService currentAccountService;
	@Autowired
	private SavingsAccountService savingsAccountService;
	
	@Override
	public List<BankAccount> findAllBankAccountByCustomerId(int customerId) {
		List<BankAccount> bankAccounts = currentAccountService.findAllCurrentBankAccountsByCustomerId(customerId);
		bankAccounts.addAll(savingsAccountService.findAllSavingsBankAccountsByCustomerId(customerId));
		return bankAccounts;
	}
	
	@Override
	public Optional<BankAccount> findBankAccountByAccountNo(long accountNo) {
		return bankAccountRepository.findById(accountNo);
	}
	
	@Override
	public int deposit(BankAccount account, double amount) throws GiftCheckpointException {
		double balance = account.getBalance();
		long accountNo = account.getAccountNo();
		int updated = 0;
		if(account instanceof CurrentAccount) {
			updated = bankAccountRepository.updateBalance(accountNo, amount + balance);
		} else if(account instanceof SavingsAccount) {
			SavingsAccount savingsAcc = (SavingsAccount) account;
			updated = bankAccountRepository.updateBalance(accountNo, amount + balance);
			double giftCheck = savingsAcc.getGiftCheck() + amount;
			if(giftCheck >= 1000) {
				giftCheck = giftCheck - 1000;
				savingsAccountService.updateGiftFlag(accountNo, giftCheck);
				throw new GiftCheckpointException();
			}
			savingsAccountService.updateGiftFlag(accountNo, giftCheck);
		}
		return updated;
	}
	
	@Override
	public int withdraw(BankAccount account, double amount) throws LimitExceededException {
		double balance = account.getBalance();
		long accountNo = account.getAccountNo();
		int updated = 0;
		if(account instanceof CurrentAccount) {
			CurrentAccount currentAcc = (CurrentAccount) account;
			double overdraft = currentAcc.getOverdraftLimit();
			if(amount <= balance) {
				updated = bankAccountRepository.updateBalance(accountNo, balance - amount);
			} else if(balance < 0) {
				double remainingOverdraft = overdraft - Math.abs(balance);
				if(remainingOverdraft >= 0) {
					updated = bankAccountRepository.updateBalance(accountNo, balance - amount);
				} else {
					throw new LimitExceededException("Insufficient overdraft funds");
				}
			}
		} else if(account instanceof SavingsAccount) {
			if(amount <= balance) {
				updated = bankAccountRepository.updateBalance(accountNo, balance - amount);
			} else {
				throw new LimitExceededException("Insufficient balance funds");
			}
		}
		return updated;
	}
}
