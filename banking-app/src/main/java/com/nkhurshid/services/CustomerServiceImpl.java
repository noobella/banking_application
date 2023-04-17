package com.nkhurshid.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nkhurshid.models.BankAccount;
import com.nkhurshid.models.Customer;
import com.nkhurshid.respositories.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private BankAccountService bankAccountService;

	@Override
	public Customer loginCustomer(String phoneNo, String password) {
		Customer customer = customerRepository.loginCustomer(phoneNo, password);
		if(customer != null) {
			customer = findCustomerById(customer.getCustomerId()).get();
			System.out.println(customer);
//			List<BankAccount> ba = bankAccountService.findAllBankAccountByCustomerId(customer.getCustomerId());
//			customer.setAccounts(ba);	
		}
		return customer;
	}

	@Override
	public Customer registerCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public void removeCustomer(Customer customer) {
		customerRepository.delete(customer);
	}
	
	@Override
	public Optional<Customer> findCustomerById(int id) {
		return customerRepository.findById(id);
	}
	
	@Override
	public Customer updateCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	
}
