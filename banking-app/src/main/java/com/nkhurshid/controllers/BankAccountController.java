package com.nkhurshid.controllers;

import java.net.http.HttpRequest;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nkhurshid.models.BankAccount;
import com.nkhurshid.models.CurrentAccount;
import com.nkhurshid.models.Customer;
import com.nkhurshid.models.SavingsAccount;
import com.nkhurshid.models.Transaction;
import com.nkhurshid.models.TransactionType;
import com.nkhurshid.services.BankAccountService;
import com.nkhurshid.services.CurrentAccountService;
import com.nkhurshid.services.GiftCheckpointException;
import com.nkhurshid.services.LimitExceededException;
import com.nkhurshid.services.SavingsAccountService;
import com.nkhurshid.services.TransactionService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class BankAccountController {

	@Autowired
	private BankAccountService bankAccountService;
	@Autowired
	private CurrentAccountService currentAccountService;
	@Autowired
	private SavingsAccountService savingsAccountService;
	@Autowired
	private TransactionService transactionService;

	
	@GetMapping("/viewAccounts")
	public ModelAndView customerAccounts(HttpServletRequest request) {
		Customer customer = (Customer) request.getSession().getAttribute("customer");
//		currentAccountService.addCurrentAccount(new CurrentAccount(customer, 0, LocalDateTime.now(), 1000.0));
//		savingsAccountService.addSavingsAccount(new SavingsAccount(customer, 0, LocalDateTime.now()));
		List<BankAccount> accounts = bankAccountService.findAllBankAccountByCustomerId(customer.getCustomerId());
		return new ModelAndView("view_accounts", "accounts", accounts);
		
	}
	
	@GetMapping("/viewAccounts/{accountNo}")
	public ModelAndView viewIndividualAccount(@PathVariable("accountNo") long accountNo) {
		Optional<BankAccount> account = bankAccountService.findBankAccountByAccountNo(accountNo);
		return new ModelAndView("view_individual_account", "account", account.get());
	}
	
	@GetMapping("viewAccounts/deposit/{accountNo}")
	public String viewDeposit(@PathVariable("accountNo") long accountNo) {
		return "deposit";
	}
	
	@GetMapping("viewAccounts/withdraw/{accountNo}")
	public String viewWithdraw(@PathVariable("accountNo") long accountNo) {
		return "withdraw";
	}
	
	@PostMapping("viewAccounts/deposit/{accountNo}")
	public ModelAndView depositForm(@PathVariable("accountNo") long accountNo, @RequestParam("amount") double amount, HttpServletRequest request) {
		BankAccount account = bankAccountService.findBankAccountByAccountNo(accountNo).get();
		Transaction completeTransaction = null;
		try {
			bankAccountService.deposit(account, amount);
		} catch (GiftCheckpointException e) {
			// TODO: GET AWARD
			request.setAttribute("reward", "You have won a mystery reward");
		}
		completeTransaction = transactionService.addTransaction(new Transaction(account, TransactionType.DEPOSIT, amount, account.getBalance(), LocalDateTime.now()));
		return new ModelAndView("transaction_completed", "transaction", completeTransaction);
	}
	
	@PostMapping("viewAccounts/withdraw/{accountNo}")
	public ModelAndView withdrawForm(@PathVariable("accountNo") long accountNo, @RequestParam("amount") double amount) {
		BankAccount account = bankAccountService.findBankAccountByAccountNo(accountNo).get();
		
		Transaction completeTransaction = null;
		try {
			bankAccountService.withdraw(account, amount);
			completeTransaction = transactionService.addTransaction(new Transaction(account, TransactionType.WITHDRAW, amount, account.getBalance(), LocalDateTime.now()));
		} catch (LimitExceededException e) {
			Transaction failedTransaction = new Transaction(account, TransactionType.REVERSAL, amount, account.getBalance(), LocalDateTime.now());
			transactionService.addTransaction(failedTransaction);
			return new ModelAndView("transaction_failed", "msg", e.getMessage());
		}
		return new ModelAndView("transaction_completed", "transaction", completeTransaction);
	}
	
	@GetMapping("/addAccount")
	public String addAccount() {
		return "add_account";
	}
	
	@GetMapping("/addCurrentAccount")
	public String viewAddCurrentAccount() {
		return "add_current_account";
	}
	
	@PostMapping("/addCurrentAccount") 
	public ModelAndView addCurrentAccount(@RequestParam("amount") double amount, @RequestParam("overdraft") double overdraftLimit, HttpServletRequest request) {
		Customer customer = (Customer) request.getSession().getAttribute("customer");
		BankAccount account = currentAccountService.addCurrentAccount(new CurrentAccount(customer, amount, LocalDateTime.now(), overdraftLimit));
		if(amount > 0) {
			transactionService.addTransaction(new Transaction(account, TransactionType.OPENING_BALANCE, amount, 0, LocalDateTime.now()));
		}
		return new ModelAndView("account_created", "account", account);
	}
	
	@GetMapping("/addSavingsAccount")
	public String viewAddSavingsAccount() {
		return "add_savings_account";
	}
	
	@PostMapping("/addSavingsAccount") 
	public ModelAndView addSavingsAccount(@RequestParam("amount") double amount, HttpServletRequest request) {
		Customer customer = (Customer) request.getAttribute("customer");
		BankAccount account = savingsAccountService.addSavingsAccount(new SavingsAccount(customer, amount, LocalDateTime.now()));
		if(amount > 0) {
			transactionService.addTransaction(new Transaction(account, TransactionType.OPENING_BALANCE, amount, 0, LocalDateTime.now()));
		}
		return new ModelAndView("account_created", "account", account);
	}
	
}
