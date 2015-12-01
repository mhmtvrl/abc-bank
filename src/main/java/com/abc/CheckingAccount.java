package com.abc;

public class CheckingAccount extends AbstractAccount implements Account {

	public CheckingAccount(String accountId) {
		super(accountId);
	}

	@Override
	public Double calculateInterest(Double amount) {
		return amount * 0.001;
	}
	
	@Override
	public String toString() {
		return "Checking Account\n" + super.toString();
	}

}
