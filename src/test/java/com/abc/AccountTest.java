package com.abc;

import static org.junit.Assert.*;

import org.junit.Test;

public class AccountTest {

	@Test(expected = IllegalArgumentException.class)
	public void testDepositZeroDollar() {
		Account checkingAccount = new CheckingAccount("1");
		checkingAccount.deposit(0.0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testDepositLessThanZeroDollar() {
		Account checkingAccount = new CheckingAccount("1");
		checkingAccount.deposit(-100.0);
	}
	
	@Test
	public void testDepositGreaterThanZeroDollar(){
		Account checkingAccount = new CheckingAccount("1");
		checkingAccount.deposit(100.0);
		assertEquals(new Double(100.0), checkingAccount.sumTransactions());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testWithdrawFromZeroBalance(){
		Account checkingAccount = new CheckingAccount("1");
		checkingAccount.withdraw(100.0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testWithdrawOveramount(){
		Account checkingAccount = new CheckingAccount("1");
		checkingAccount.deposit(100.0);
		checkingAccount.withdraw(110.0);
	}
	
	@Test
	public void testWithdrawWholeBalance(){
		Account checkingAccount = new CheckingAccount("1");
		checkingAccount.deposit(100.0);
		checkingAccount.withdraw(100.0);
		assertEquals(new Double(0.0), checkingAccount.sumTransactions());
	}
	
	@Test
	public void testWithdrawSomeAmount(){
		Account checkingAccount = new CheckingAccount("1");
		checkingAccount.deposit(100.0);
		checkingAccount.withdraw(50.0);
		assertEquals(new Double(50.0), checkingAccount.sumTransactions());
	}
	
	@Test
	public void testSumTransactionEmptyAccount(){
		Account checkingAccount = new CheckingAccount("1");
		assertEquals(new Double(0.0), checkingAccount.sumTransactions());
	}
	
	@Test
	public void testSumTransactionNonEmptyAccount(){
		Account checkingAccount = new CheckingAccount("1");
		checkingAccount.deposit(100.0);
		checkingAccount.deposit(100.0);
		assertEquals(new Double(200.0), checkingAccount.sumTransactions());
	}
	
	@Test
	public void testCalculateInterestOfCheckingAccount(){
		Account checkingAccount = new CheckingAccount("1");
		assertEquals(new Double(1.0), checkingAccount.calculateInterest(1000.0));
	}
	
	@Test
	public void testCalculateInterestOfSavingAccountWithLesserThanThousand(){
		Account savingsAccount = new SavingsAccount("1");
		assertEquals(new Double(0.999), savingsAccount.calculateInterest(999.0));
	}
	
	@Test
	public void testCalculateInterestOfSavingAccountThousand(){
		Account savingsAccount = new SavingsAccount("1");
		assertEquals(new Double(1.0), savingsAccount.calculateInterest(1000.0));
	}
	
	@Test
	public void testCalculateInterestOfSavingAccountwithGreaterThanThousand(){
		Account savingsAccount = new SavingsAccount("1");
		assertEquals(new Double(3.0), savingsAccount.calculateInterest(2000.0));
	}
	
	@Test
	public void testCalculateInterestOfMaxiSavingsAccountsWithLessThanThousand(){
		Account maxiSavingsAccounts = new MaxiSavingsAccounts("1");
		assertEquals(new Double(10.0), maxiSavingsAccounts.calculateInterest(500.0));
	}
	
	@Test
	public void testCalculateInterestOfMaxiSavingsAccountsWithThousand(){
		Account maxiSavingsAccounts = new MaxiSavingsAccounts("1");
		assertEquals(new Double(20.0), maxiSavingsAccounts.calculateInterest(1000.0));
	}
	
	@Test
	public void testCalculateInterestOfMaxiSavingsAccountsWithGreaterThanThousand(){
		Account maxiSavingsAccounts = new MaxiSavingsAccounts("1");
		assertEquals(new Double(45.0), maxiSavingsAccounts.calculateInterest(1500.0));
	}
	
	@Test
	public void testCalculateInterestOfMaxiSavingsAccountsWithTwoThousand(){
		Account maxiSavingsAccounts = new MaxiSavingsAccounts("1");
		assertEquals(new Double(70.0), maxiSavingsAccounts.calculateInterest(2000.0));
	}
	
	@Test
	public void testCalculateInterestOfMaxiSavingsAccountsTwoWithGreaterThanThousand(){
		Account maxiSavingsAccounts = new MaxiSavingsAccounts("1");
		assertEquals(new Double(120.0), maxiSavingsAccounts.calculateInterest(2500.0));
	}

}
