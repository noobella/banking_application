package com.nkhurshid.respositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nkhurshid.models.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	
	@Query(value = "select new Transaction(t.transactionId, t.transactionType, t.amount, t.balance, t.transactionDate) from Transaction t where t.bankAccount.accountNo = :accountNo")
	public List<Transaction> findAllTransactionsByAccountNo(@Param("accountNo") long accountNo);

}
