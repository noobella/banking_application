package com.nkhurshid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.nkhurshid.models.AccountType;
import com.nkhurshid.models.BankAccount;
import com.nkhurshid.models.Customer;
import com.nkhurshid.respositories.BankAccountRepository;
import com.nkhurshid.respositories.CurrentAccountRepository;
import com.nkhurshid.respositories.SavingsAccountRepository;
import com.nkhurshid.services.BankAccountServiceImpl;
import com.nkhurshid.services.CurrentAccountServiceImpl;
import com.nkhurshid.services.GiftCheckpointException;
import com.nkhurshid.services.SavingsAccountServiceImpl;

@ExtendWith(MockitoExtension.class)
class BankAccountServiceTest {
	
	@Mock
	private BankAccountRepository bankAccountRepository;
	@InjectMocks
	private BankAccountServiceImpl bankAccountServiceImpl;
	@Mock 
	private CurrentAccountRepository currentAccountRepository;
	@InjectMocks
	private CurrentAccountServiceImpl currentAccountServiceImpl;
	@Mock
	private SavingsAccountRepository savingsAccountRepository;
	@InjectMocks
	private SavingsAccountServiceImpl savingsAccountServiceImpl;

	@Test
	void testfindAllCurrentBankAccountsByCustomerId() {
		
		Customer customer = new Customer(1, "Nabeeha", "Khurshid", 145, "Fairlands Avenue",
				"CR7 6HJ", "0786470009", "pass");
		List<BankAccount> accounts = List.of(new BankAccount(customer, 0, LocalDateTime.of(2023, 03, 23, 10, 43), AccountType.CUR));
		when(currentAccountServiceImpl.findAllCurrentBankAccountsByCustomerId(1)).thenReturn(accounts);
		
		List<BankAccount> result = currentAccountServiceImpl.findAllCurrentBankAccountsByCustomerId(1);
		assertEquals(accounts, result);
	}
	
	@Test
	void testfindAllSavingsBankAccountsByCustomerId() {
		
		Customer customer = new Customer(1, "Nabeeha", "Khurshid", 145, "Fairlands Avenue",
				"CR7 6HJ", "0786470009", "pass");
		List<BankAccount> accounts = List.of(new BankAccount(customer, 0, LocalDateTime.of(2023, 03, 23, 10, 43), AccountType.SAV));
		when(savingsAccountServiceImpl.findAllSavingsBankAccountsByCustomerId(1)).thenReturn(accounts);
		
		List<BankAccount> result = savingsAccountServiceImpl.findAllSavingsBankAccountsByCustomerId(1);
		assertEquals(accounts, result);
	}
	
	@Test
	void testDepositCurrentAccount() {
		
		Customer customer = new Customer(1, "Nabeeha", "Khurshid", 145, "Fairlands Avenue",
				"CR7 6HJ", "0786470009", "pass");
		BankAccount curAccount = new BankAccount(customer, 0, LocalDateTime.of(2023, 01, 23, 10, 47), AccountType.CUR);
		int expected = 1;
		
		try {
			when(bankAccountServiceImpl.deposit(curAccount, 100)).thenReturn(1);
			int result = bankAccountServiceImpl.deposit(curAccount, 100);
			assertEquals(expected, result);
		} catch (GiftCheckpointException e) {
			e.printStackTrace();
		}	
		
	}
	
	@Test()
	void testDepositSavingsAccountThrowsException() {
		
		Customer customer = new Customer(1, "Nabeeha", "Khurshid", 145, "Fairlands Avenue",
				"CR7 6HJ", "0786470009", "pass");
		BankAccount savAccount = mock(BankAccount.class);

		try {
			when(bankAccountServiceImpl.deposit(savAccount, 1001)).thenThrow(GiftCheckpointException.class);
			assertThrows(GiftCheckpointException.class, () -> {bankAccountServiceImpl.deposit(savAccount, 1001);});
		} catch (GiftCheckpointException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
