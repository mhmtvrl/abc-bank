package com.abc;

public class CheckingAccount extends AbstractAccount implements Account {

	public CheckingAccount(String accountId) {
		super(accountId);
	}

	@Override
	protected Double calculateInterest(Double amount) {
		return amount * Constants.CHECKING_ACCOUNT_INTEREST_RATE;
	}
	
	@Override
	public String toString() {
		return "Checking Account\n" + super.toString();
	}

}
