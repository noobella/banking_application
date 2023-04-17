package com.nkhurshid.models;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="current_account")
public class CurrentAccount extends BankAccount {

	@Column(name="overdraft_limit")
	private double overdraftLimit;

	public CurrentAccount() {
		super();
	}

	public CurrentAccount(Customer customer, double balance, LocalDateTime dateOpened, double overdraftLimit) {
		super(customer, balance, dateOpened, AccountType.CUR);
		this.overdraftLimit = overdraftLimit;
	}
	
	public CurrentAccount(long accountNo, Customer customer, double balance, LocalDateTime dateOpened,
			List<Transaction> transactions, double overdraftLimit) {
		super(accountNo, customer, balance, dateOpened, AccountType.CUR, transactions);
		this.overdraftLimit = overdraftLimit;
	}
	
	public CurrentAccount(long accountNo, Customer customer, double balance, LocalDateTime dateOpened, double overdraftLimit) {
		super(accountNo, customer, balance, dateOpened, AccountType.CUR);
		this.overdraftLimit = overdraftLimit;
	}

	public double getOverdraftLimit() {
		return overdraftLimit;
	}

	public void setOverdraftLimit(double overdraftLimit) {
		this.overdraftLimit = overdraftLimit;
	}
	
}
