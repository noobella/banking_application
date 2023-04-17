package com.nkhurshid.respositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nkhurshid.models.BankAccount;
import com.nkhurshid.models.CurrentAccount;

@Repository
public interface CurrentAccountRepository extends JpaRepository<CurrentAccount, Long> {

	@Query(value = "select new CurrentAccount(ca.accountNo, ca.customer, ca.balance, ca.dateOpened, ca.overdraftLimit) from CurrentAccount ca where ca.customer.customerId = :customerId")
	public List<BankAccount> findAllCurrentBankAccountsByCustomerId(@Param("customerId") int customerId);
	
}
