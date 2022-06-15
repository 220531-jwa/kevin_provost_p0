package dev.provost.models;

public class Account {
	
	private int accountId;
	private double balance;
	private boolean isChecking;
	private int userId;



	public Account() {
		super();
	}
	
	public Account(int accountId, double balance, boolean isChecking, int userid) {
		this.accountId = accountId;
		this.balance = balance;
		this.isChecking = isChecking;
		this.userId = userid;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userid) {
		this.userId = userid;
	}

	public int getId() {
		return accountId;
	}

	public void setId(int accountId) {
		this.accountId = accountId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public boolean getIsChecking() {
		return isChecking;
	}

	public void setChecking(boolean isChecking) {
		this.isChecking = isChecking;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", balance=" + balance + ", isChecking=" + isChecking + ", userid=" + userId + "]";
	}
	
	
}