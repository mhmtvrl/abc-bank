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

}
