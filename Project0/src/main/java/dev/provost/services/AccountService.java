package dev.provost.services;

import java.util.List;

import dev.provost.models.Account;
import dev.provost.repositories.AccountDAO;

public class AccountService {
	
	private static AccountDAO accountDao = new AccountDAO();
	
	public Account createAccount(Account a, int clientId) {
		Account createdAccount = accountDao.createAccount(a, clientId);
		return createdAccount;
	}
	
	public Account getAccountbyAccountId(int accountId, int clientId) throws Exception {
		Account a = accountDao.getAccountbyAccountId(accountId, clientId);
		
		if (a == null) {
			throw new Exception("Account not found");
		}
		
		return a;
		
	}
	
	public List<Account> getAccountsByClientId(int clientId) throws Exception {
		List<Account> a = accountDao.getAccountsByClientId(clientId);
		
		if (a == null) {
			throw new Exception("Accounts not found");
		}


		return a;
	}
	
	public void updateAccount(Account aChanged, int accountId, int clientId) {
		accountDao.updateAccount(aChanged, accountId, clientId);
	}	
	
	public void deleteAccount(int accountId) {
		accountDao.deleteAccount(accountId);
	}

}
