package com.nkhurshid.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "transaction")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="transaction_id")
	private long transactionId;
	@ManyToOne(fetch = FetchType.LAZY)
	// @JoinColumn(name="account_no")
	private BankAccount bankAccount;
	@Column(name="transaction_type")
	@Enumerated(EnumType.STRING)
	private TransactionType transactionType;
	@Column(name="amount")
	private double amount;
	@Column(name="balance")
	private double balance;
	@Column(name="transaction_date")
	private LocalDateTime transactionDate;
	
	public Transaction(long transactionId, BankAccount bankAccount, TransactionType transactionType, double amount,
			double balance, LocalDateTime transactionDate) {
		super();
		this.transactionId = transactionId;
		this.bankAccount = bankAccount;
		this.transactionType = transactionType;
		this.amount = amount;
		this.balance = balance;
		this.transactionDate = transactionDate;
	}
	
	public Transaction(BankAccount bankAccount, TransactionType transactionType, double amount,
			double balance, LocalDateTime transactionDate) {
		super();
		this.bankAccount = bankAccount;
		this.transactionType = transactionType;
		this.amount = amount;
		this.balance = balance;
		this.transactionDate = transactionDate;
	}
	
	public Transaction(long transactionId, TransactionType transactionType, double amount,
			double balance, LocalDateTime transactionDate) {
		super();
		this.transactionId = transactionId;
		this.transactionType = transactionType;
		this.amount = amount;
		this.balance = balance;
		this.transactionDate = transactionDate;
	}

	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}
	
}
