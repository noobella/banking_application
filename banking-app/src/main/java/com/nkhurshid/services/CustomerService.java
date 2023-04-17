package com.nkhurshid.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nkhurshid.models.BankAccount;
import com.nkhurshid.models.Customer;

public interface CustomerService {
	
	public Customer loginCustomer(String phoneNo, String password);
	public Customer registerCustomer(Customer customer);
	public void removeCustomer(Customer customer);
	public Optional<Customer> findCustomerById(int id);
	public Customer updateCustomer(Customer customer);

}
