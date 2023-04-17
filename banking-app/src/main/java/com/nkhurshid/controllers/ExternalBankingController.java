package com.nkhurshid.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nkhurshid.models.BankAccount;
import com.nkhurshid.models.Customer;
import com.nkhurshid.models.LoginForm;
import com.nkhurshid.services.BankAccountService;
import com.nkhurshid.services.CustomerService;
import com.nkhurshid.services.LimitExceededException;

@RestController
@RequestMapping("api/external-banking")
public class ExternalBankingController {

	@Autowired
	private CustomerService customerService;
	@Autowired
	private BankAccountService bankAccountService;

	@PostMapping
	public HttpStatus loginCustomer(@RequestBody LoginForm loginForm) {
		boolean exists = false;
		Customer customer = customerService.loginCustomer(loginForm.getPhoneNo(), loginForm.getPassword());
		if(customer != null) {
			List<BankAccount> accounts = bankAccountService.findAllBankAccountByCustomerId(customer.getCustomerId());
			for(BankAccount account: accounts) {
				if(account.getAccountNo() == loginForm.getAccountNo()) {
					exists = true;
					break;
				}
			}
		}
		// return exists ? new ResponseEntity<String>("Account exists", HttpStatus.OK) : new ResponseEntity<String>("Account doesn't exist", HttpStatus.NOT_FOUND) ;
		return exists ? HttpStatus.OK : HttpStatus.NOT_FOUND;
	}
	
	@PostMapping("/withdraw")
	public HttpStatus withdraw(@RequestBody LoginForm loginForm) {
		int update = -1;
		Optional<BankAccount> account = bankAccountService.findBankAccountByAccountNo(loginForm.getAccountNo());
		try {
			if(account.isPresent()) {
				update = bankAccountService.withdraw(account.get(), loginForm.getWithdrawAmount());
				System.out.println(update);
			}
		} catch (LimitExceededException e) {}
		return (update ==  0) ? HttpStatus.NOT_FOUND : HttpStatus.OK;
	}
	
}
