package com.nkhurshid.models;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="bank_account")
public class BankAccount {
	
	@Id
	@GeneratedValue(generator = "sequence-generator")
	@GenericGenerator(
			name = "sequence-generator",
			strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
			parameters = {
				@Parameter(name="sequence_name", value="account_sequence"),
				@Parameter(name="initial_value", value="1000000"),
				@Parameter(name = "increment_size", value = "1")
			}
	)
	@Column(name="account_no")
	private long accountNo;
	@ManyToOne(cascade = CascadeType.REMOVE)
	private Customer customer;
	@Column(name="balance")
	private double balance;
	@Column(name="date_opened")
	private LocalDateTime dateOpened;
	@Column(name="account_type")
	@Enumerated(EnumType.STRING)
	private AccountType accountType;
	@OneToMany(mappedBy = "bankAccount")
	private List<Transaction> transactions;
	
	public BankAccount() {}
	
	
	public BankAccount(Customer customer, double balance, LocalDateTime dateOpened, AccountType accountType) {
		super();
		this.customer = customer;
		this.balance = balance;
		this.dateOpened = dateOpened;
		this.accountType = accountType;
	}
	
	public BankAccount(long accountNo, Customer customer, double balance, LocalDateTime dateOpened, AccountType accountType,
			List<Transaction> transactions) {
		super();
		this.accountNo = accountNo;
		this.customer = customer;
		this.balance = balance;
		this.dateOpened = dateOpened;
		this.accountType = accountType;
		this.transactions = transactions;
	}
	
	public BankAccount(long accountNo, Customer customer, double balance, LocalDateTime dateOpened, AccountType accountType) {
		super();
		this.accountNo = accountNo;
		this.customer = customer;
		this.balance = balance;
		this.dateOpened = dateOpened;
		this.accountType = accountType;
	}

	public long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public LocalDateTime getDateOpened() {
		return dateOpened;
	}

	public void setDateOpened(LocalDateTime dateOpened) {
		this.dateOpened = dateOpened;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	

	public AccountType getAccountType() {
		return accountType;
	}


	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	
}
