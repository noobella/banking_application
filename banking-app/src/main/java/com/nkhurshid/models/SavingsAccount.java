package com.nkhurshid.models;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="savings_account")
public class SavingsAccount extends BankAccount {

	@Column(name="interest_rate", columnDefinition = "double(10,2) default 0.15")
	private double interestRate;
	@Column(name="gift_check", columnDefinition = "double(10,2) default 0.0")
	private double giftCheck;

	public SavingsAccount() {
		super();
	}

	public SavingsAccount(Customer customer, double balance, LocalDateTime dateOpened) {
		super(customer, balance, dateOpened, AccountType.SAV);
	}
	
	public SavingsAccount(long accountNo, Customer customer, double balance, LocalDateTime dateOpened,
			List<Transaction> transactions, double interestRate, double giftCheck) {
		super(accountNo, customer, balance, dateOpened,  AccountType.SAV, transactions);
		this.interestRate = interestRate;
		this.giftCheck = giftCheck;
	}
	
	public SavingsAccount(long accountNo, Customer customer, double balance, LocalDateTime dateOpened, double interestRate, double giftCheck) {
		super(accountNo, customer, balance, dateOpened, AccountType.SAV);
		this.interestRate = interestRate;
		this.giftCheck = giftCheck;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public double getGiftCheck() {
		return giftCheck;
	}

	public void setGiftCheck(double giftCheck) {
		this.giftCheck = giftCheck;
	}
	
}
