
package com.nkhurshid.respositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nkhurshid.models.BankAccount;

import jakarta.transaction.Transactional;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long>{

	@Query(value = "update BankAccount ba set ba.balance = :amount where ba.accountNo = :accountNo")
	@Transactional
	@Modifying
	public int updateBalance(@Param("accountNo") long accountNo, @Param("amount") double amount);
	
}
