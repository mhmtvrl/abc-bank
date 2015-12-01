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
	
	public void deposit(Double amount){
		if(amount.compareTo(0.0) < 0 || amount.compareTo(0.0) == 0){
			throw new IllegalArgumentException("Amount must be greater than zero");
		} else {
			transactions.add(new Transaction(amount));
		}
	}

	public void withdraw(Double amount){
		Double sumTransactions = this.sumTransactions() - amount;
		int toCompare = sumTransactions.compareTo(0.0);
		if(toCompare < 0){
			throw new IllegalArgumentException("Not enough balance");
		}
		if(amount.compareTo(0.0) < 0 || amount.compareTo(0.0) == 0){
			throw new IllegalArgumentException("Amount must be greater than zero");
		} else {
			transactions.add(new Transaction(-amount));
		}
	}

	public Double interestEarned(){
		Double amount = sumTransactions();
		return calculateInterest(amount);
	}

	public Double sumTransactions(){
		double amount = 0.0;
        for (Transaction t: transactions)
            amount += t.amount;
        return amount;
	}
	
	public abstract Double calculateInterest(Double amount);
	
	@Override
	public String toString() {		
		String accountSummary = "";
		
		double total = 0.0;
        for (Transaction t : this.transactions) {
        	accountSummary += "  " + (t.amount < 0 ? "withdrawal" : "deposit") + " " + Util.toDollars(t.amount) + "\n";
            total += t.amount;
        }
        accountSummary += "Total " + Util.toDollars(total);
		return accountSummary;
	}

	public String getAccountId() {
		return accountId;
	}
	
	

}
