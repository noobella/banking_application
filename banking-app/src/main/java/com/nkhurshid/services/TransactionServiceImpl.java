package com.nkhurshid.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nkhurshid.models.Transaction;
import com.nkhurshid.respositories.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public List<Transaction> findAllTransactionsByAccountNo(long accountNo) {
		return transactionRepository.findAllTransactionsByAccountNo(accountNo);
	}

	@Override
	public Transaction addTransaction(Transaction transaction) {
		return transactionRepository.save(transaction);
	}

}
