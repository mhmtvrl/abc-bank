package com.abc;

public class MaxiSavingsAccounts extends AbstractAccount implements Account {

	public MaxiSavingsAccounts(String accountId) {
		super(accountId);
	}

	@Override
	protected double calculateInterest(double amount) {
		if (amount <= 1000)
            return amount * 0.02;
        if (amount <= 2000)
            return 20 + (amount-1000) * 0.05;
        return 70 + (amount-2000) * 0.1;
	}
	
	@Override
	public String toString() {
		return "Maxi Savings Account\n" + super.toString();
	}

}
