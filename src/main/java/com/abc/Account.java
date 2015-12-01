package com.abc;

public interface Account {
	public void deposit(Double amount);
	public void withdraw(Double amount);
	public Double interestEarned();
	public Double sumTransactions();
	public Double calculateInterest(Double amount);
	public String getAccountId();
}
