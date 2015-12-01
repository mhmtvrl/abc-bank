package com.abc;

public interface Account {
	public void deposit(Double amount);
	public void withdraw(Double amount);
	public double interestEarned();
	public double sumTransactions();
}
