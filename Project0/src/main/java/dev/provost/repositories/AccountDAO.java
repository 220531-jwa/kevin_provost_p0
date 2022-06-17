package dev.provost.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.provost.models.Account;
import dev.provost.utils.ConnectionUtil;

public class AccountDAO {
	
	private static ConnectionUtil cu = ConnectionUtil.getConnectionUtil();
	
	/*
	 * Create - Make a new account
	 * 			-Add a bank account
	 * Read - Read (query) DB data
	 * 			-Check balance
	 * Update - Update an existing record in our DB
	 * 			-Account deposit, withdrawl, transfer
	 * Delete - Delete an existing DB record
	 * 			-Delete an account
	 */

//	Create
	public Account createAccount(Account a, int clientId) {
		
		String sql = "insert into accounts values (default, ?, ?, ?) returning *";
		
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, a.getBalance()); //defining IN parameters (?)
			ps.setBoolean(2, a.getIsChecking());
			ps.setInt(3, clientId);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				return new Account(
						rs.getInt("accountid"),
						rs.getDouble("balance"),
						rs.getBoolean("ischecking"),
						rs.getInt("clientid")
						);	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
//	Read
	
	//List account balance by Account ID
	public Account getAccountbyAccountId(int accountId, int clientId) {
			
		String sql = "select * from accounts where accountid = ? AND clientid = ?";
		
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, accountId);
			ps.setInt(2, clientId);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				return new Account (
						rs.getInt("accountId"),
						rs.getDouble("balance"),
						rs.getBoolean("ischecking"),
						rs.getInt("clientid")
						);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//List account balances by Client ID
	public List<Account> getAccountsByClientId(int clientId) {
		
		List<Account> accounts = new ArrayList<>();
				
		String sql = "select * from accounts where clientid = ?";
		
		try (Connection conn = cu.getConnection()) {
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, clientId);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int accountId = rs.getInt("accountid");
				double balance = rs.getDouble("balance");
				boolean isChecking = rs.getBoolean("ischecking");
				
				Account a = new Account(accountId, balance, isChecking, clientId);
				
				accounts.add(a);
						
			}
			return accounts;
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}

	
// Update	
	
	public void updateAccount(Account aChanged, int accountId, int clientId) {
		
		String sql = "update accounts set balance = ?, ischecking = ?, clientid = ? where accountid = ?";
		
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, aChanged.getBalance());
			ps.setBoolean(2, aChanged.getIsChecking());
			ps.setInt(3, clientId);
			ps.setInt(4, accountId);
			
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}	
	
// Delete
	
	public void deleteAccount(int accountId) {
		String sql = "delete from accounts where accountid = ?";
		
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, accountId);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
