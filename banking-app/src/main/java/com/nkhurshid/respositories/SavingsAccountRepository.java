package com.nkhurshid.respositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nkhurshid.models.BankAccount;
import com.nkhurshid.models.SavingsAccount;

import jakarta.transaction.Transactional;

@Repository
public interface SavingsAccountRepository extends JpaRepository<SavingsAccount, Long> {
	
	@Query(value = "select new SavingsAccount(sa.accountNo, sa.customer, sa.balance, sa.dateOpened, sa.interestRate, sa.giftCheck) from SavingsAccount sa where sa.customer.customerId = :customerId")
	public List<BankAccount> findAllSavingsBankAccountsByCustomerId(@Param("customerId") int customerId);
	
	@Query(value = "update SavingsAccount sa set sa.giftCheck = :amount where sa.accountNo = :accountNo")
	@Transactional
	@Modifying
	public int updateGiftFlag(@Param("accountNo") long accountNo, @Param("amount") double amount); 

}
