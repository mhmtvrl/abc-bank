package com.abc;

public interface Account {
	public void deposit(double amount);
	public void withdraw(double amount);
	public double interestEarned();
	public double sumTransactions();
}
