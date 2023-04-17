package com.nkhurshid.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.nkhurshid.models.BankAccount;
import com.nkhurshid.models.Transaction;
import com.nkhurshid.services.BankAccountService;
import com.nkhurshid.services.TransactionService;

@RestController
public class TransactionRestController {
	
	@Autowired
	private TransactionService transactionService;
	
	@GetMapping("transactions/{accountNo}")
	public List<Transaction> viewAccountTransactions(@PathVariable("accountNo") long accountNo) {
		return transactionService.findAllTransactionsByAccountNo(accountNo);
	}
}
