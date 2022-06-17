package dev.provost.models;

public class Account {
	
	private int accountId;
	private double balance;
	private boolean isChecking;
	private int clientId;



	public Account() {
		super();
	}
	
	public Account(int accountId, double balance, boolean isChecking, int clientId) {
		this.accountId = accountId;
		this.balance = balance;
		this.isChecking = isChecking;
		this.clientId = clientId;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
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
		return "Account [accountId=" + accountId + ", balance=" + balance + ", isChecking=" + isChecking + ", clientId=" + clientId + "]";
	}
	
	
}