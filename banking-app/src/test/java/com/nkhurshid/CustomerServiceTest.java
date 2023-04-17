package com.nkhurshid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.nkhurshid.models.BankAccount;
import com.nkhurshid.models.Customer;
import com.nkhurshid.respositories.BankAccountRepository;
import com.nkhurshid.respositories.CustomerRepository;
import com.nkhurshid.services.BankAccountServiceImpl;
import com.nkhurshid.services.CustomerServiceImpl;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

	@Mock
	private CustomerRepository customerRepository;
	@InjectMocks
	private CustomerServiceImpl customerServiceImpl;
	
	@Test
	void testLoginCustomer() {
		
		Customer customer = new Customer(1, "Nabeeha", "Khurshid", 145, "Fairlands Avenue",
				"CR7 6HJ", "0786470009", "pass");
		
		when(customerServiceImpl.loginCustomer("0786470009", "pass")).thenReturn(customer);
		when(customerServiceImpl.findCustomerById(1)).thenReturn(Optional.of(customer));
		
		Customer testCustomer = customerServiceImpl.loginCustomer(customer.getPhoneNo(), "pass");
		assertEquals(customer, testCustomer);
		
	}
	
	@Test
	void testRegisterCustomer() {
		
		Customer customer = new Customer(1, "Nabeeha", "Khurshid", 145, "Fairlands Avenue",
				"CR7 6HJ", "0786470009", "pass");
		
		when(customerServiceImpl.registerCustomer(customer)).thenReturn(customer);
		
		Customer testCustomer = customerServiceImpl.registerCustomer(customer);
		assertEquals(customer, testCustomer);
		
	}
	
	@Test
	void testFindCustomerById() {
		
		Optional<Customer> customer = Optional.of(new Customer(1, "Nabeeha", "Khurshid", 145, "Fairlands Avenue",
				"CR7 6HJ", "0786470009", "pass"));
		
		when(customerServiceImpl.findCustomerById(1)).thenReturn(customer);
		
		Optional<Customer> testCustomer = customerServiceImpl.findCustomerById(1);
		assertEquals(customer, testCustomer);
		
	}
	
	@Test
	void testUpdateCustomer() {
		
		Customer customer = new Customer(1, "Nabeeha", "Khurshid", 145, "Fairlands Avenue",
				"CR7 6HJ", "0786470009", "pass");
		
		when(customerServiceImpl.updateCustomer(customer)).thenReturn(customer);
		
		Customer testCustomer = customerServiceImpl.updateCustomer(customer);
		assertEquals(customer, testCustomer);
		
	}
	
	
}
