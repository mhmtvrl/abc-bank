package com.abc;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Account> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<Account>();
    }

    public String getName() {
        return name;
    }

    public Customer openAccount(Account account) {
        accounts.add(account);
        return this;
    }

    public int getNumberOfAccounts() {
        return accounts.size();
    }

    public double totalInterestEarned() {
        double total = 0;
        for (Account a : accounts)
            total += a.interestEarned();
        return total;
    }

    public String getStatement() {
        String statement = null;
        statement = "Statement for " + this.name + "\n";
        double total = 0.0;
        for (Account a : accounts) {
            statement += "\n" + a.toString() + "\n";
            total += a.sumTransactions();
        }
        statement += "\nTotal In All Accounts " + Util.toDollars(total);
        return statement;
    }
    
    @Override
    public String toString() {
    	return "\n - " + this.getName() + " (" + Util.format(this.getNumberOfAccounts(), "account") + ")";
    }
    
    public Account findAccount(String accoutId){
    	for(int i = 0; i < accounts.size(); i++){
    		if(accounts.get(i).getAccountId().equals(accoutId))
    			return accounts.get(i);
    	}
    	return null;
    }
    
    public void transferMoney(String fromId, String toId, Double amount){
    	Account fromAccount = this.findAccount(fromId);
    	Account toAccount = this.findAccount((toId));
    	
    	if(fromAccount == null || toAccount == null){
    		throw new NullPointerException("Account doesn't exists");
    	}
    	
    	fromAccount.withdraw(amount);
    	toAccount.deposit(amount);
    }

}
