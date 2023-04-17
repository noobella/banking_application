package com.nkhurshid.services;

import java.util.List;

import com.nkhurshid.models.Transaction;

public interface TransactionService {
	
	public List<Transaction> findAllTransactionsByAccountNo(long accountNo);
	public Transaction addTransaction(Transaction transaction);

}
