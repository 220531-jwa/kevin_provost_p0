package dev.provost.controllers;

import java.util.List;

import dev.provost.models.Account;
import dev.provost.services.AccountService;
import io.javalin.http.Context;

public class AccountController {
	
	private static AccountService as = new AccountService();
	
	public static void createAccount(Context ctx) {
		int clientId = Integer.parseInt(ctx.pathParam("id"));
		Account accountFromRequestBody = ctx.bodyAsClass(Account.class);
		as.createAccount(accountFromRequestBody, clientId);
	}
	
	public static void getAccountsByUserId(Context ctx) {
		int userId = Integer.parseInt(ctx.pathParam("id"));
		List<Account> a = null;
		try {
			a = as.getAccountsByUserId(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ctx.status(200);
		ctx.json(a);
	}
	
	public static void getAccountbyAccountId(Context ctx) {
		int userId = Integer.parseInt(ctx.pathParam("id"));
		int accountId = Integer.parseInt(ctx.pathParam("accountId"));
		Account a = null;
		try {
			a = as.getAccountbyAccountId(accountId, userId);
		} catch (Exception e) {
			ctx.status(500);
			e.printStackTrace();
		}
		ctx.status(200);
		ctx.json(a);
	}
	
	public static void deleteAccount(Context ctx) {
		int accountId = Integer.parseInt(ctx.pathParam("accountId"));
		ctx.status(205);
		as.deleteAccount(accountId);
	}

}
