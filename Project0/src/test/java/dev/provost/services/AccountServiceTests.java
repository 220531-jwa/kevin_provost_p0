package dev.provost.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import dev.provost.models.Account;
import dev.provost.models.Client;
import dev.provost.repositories.AccountDAO;
import dev.provost.repositories.ClientDAO;

@ExtendWith(MockitoExtension.class)
class AccountServiceTests {
	
	@InjectMocks
	private static AccountService accountService;
	
	@Mock
	private static AccountDAO mockAccountDao;

	@Test
	void testCreateAccount() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAccountbyAccountId() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAccountsByClientId() {
		List<Account> accountsMock = new ArrayList<>();
		accountsMock.add(new Account(100, 1000, true, 4));
		accountsMock.add(new Account(200, 5000, false, 4));
		accountsMock.add(new Account(300, 500, true, 4));
		accountsMock.add(new Account(400, 250, false, 4));
		
		when(mockAccountDao.getAccountsByClientId(4)).thenReturn(accountsMock);
		
		try {
			assertEquals(accountsMock, accountService.getAccountsByClientId(4));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void testUpdateAccount() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteAccount() {
		fail("Not yet implemented");
	}

}
