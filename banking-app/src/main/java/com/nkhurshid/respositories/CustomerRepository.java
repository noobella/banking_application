package com.nkhurshid.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nkhurshid.models.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query(value = "select new Customer(c.customerId, c.firstName, c.lastName, c.doorNo, c.streetName, c.postcode, c.phoneNo, c.password) from Customer c where c.phoneNo = :phoneNo and c.password = :password")
	public Customer loginCustomer(@Param("phoneNo") String phoneNo, @Param("password") String password);
	
}
