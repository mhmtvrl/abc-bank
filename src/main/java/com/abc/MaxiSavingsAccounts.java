package com.abc;

public class MaxiSavingsAccounts extends AbstractAccount implements Account {

	public MaxiSavingsAccounts(String accountId) {
		super(accountId);
	}

	@Override
	protected Double calculateInterest(Double amount) {
		int toCompare = amount.compareTo(1000.0);
		if (toCompare < 0 || toCompare == 0)
            return amount * 0.02;
		toCompare = amount.compareTo(2000.0);
        if (toCompare < 0 || toCompare == 0)
            return 20 + (amount-1000) * 0.05;
        return 70 + (amount-2000) * 0.1;
	}
	
	@Override
	public String toString() {
		return "Maxi Savings Account\n" + super.toString();
	}

}
