package com.abc;

public abstract class AbstractAccount implements Account {

	public abstract void deposit(double amount);

	public abstract void withdraw(double amount);

	public abstract double interestEarned();

	public abstract double sumTransactions();

}
