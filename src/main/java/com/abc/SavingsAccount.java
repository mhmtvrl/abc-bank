package com.abc;

public class SavingsAccount extends AbstractAccount implements Account {

	public SavingsAccount(String accountId) {
		super(accountId);
	}

	@Override
	protected double calculateInterest(Double amount) {
		int toCompare = amount.compareTo(1000.0);
		if (toCompare < 0 || toCompare == 0)
            return amount * 0.001;
        else
            return 1 + (amount-1000) * 0.002;
	}
	
	@Override
	public String toString() {
		return "Savings Account\n" + super.toString();
	}
}
