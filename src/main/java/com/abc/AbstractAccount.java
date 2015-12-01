package com.abc;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractAccount implements Account {
	
	private String accountId;
	
	private List<Transaction> transactions;
	
	public AbstractAccount(String accountId){
		this.transactions = new ArrayList<Transaction>();
		this.accountId = accountId;
	}
	
	public void deposit(double amount){
		this.addTransaction(amount);
	}

	public void withdraw(double amount){
		this.addTransaction(-amount);
	}
	
	private void addTransaction(double amount){
		if(amount <= 0){
			throw new IllegalArgumentException("Amount must be greater than zero");
		} else {
			transactions.add(new Transaction(amount));
		}
	}

	public double interestEarned(){
		double amount = sumTransactions();
		return calculateInterest(amount);
	}

	public double sumTransactions(){
		double amount = 0.0;
        for (Transaction t: transactions)
            amount += t.amount;
        return amount;
	}
	
	protected abstract double calculateInterest(double amount);

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((accountId == null) ? 0 : accountId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractAccount other = (AbstractAccount) obj;
		if (accountId == null) {
			if (other.accountId != null)
				return false;
		} else if (!accountId.equals(other.accountId))
			return false;
		return true;
	}
	
	

}
