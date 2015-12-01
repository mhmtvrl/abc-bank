package com.abc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BankTest {
    private static final double DOUBLE_DELTA = 1e-15;

    @Test
    public void customerSummary() {
        Bank bank = new Bank();
        Customer john = new Customer("John");
        john.openAccount(new CheckingAccount("1"));
        bank.addCustomer(john);
        assertEquals("Customer Summary\n - John (1 account)", bank.customerSummary());
    }

    @Test
    public void checkingAccount() {
        Bank bank = new Bank();
        Account checkingAccount = new CheckingAccount("1");
        Customer bill = new Customer("Bill").openAccount(checkingAccount);
        bank.addCustomer(bill);

        checkingAccount.deposit(100.0);

        assertEquals(0.1, bank.totalInterestPaid(), DOUBLE_DELTA);
    }

    @Test
    public void savingsAccount() {
        Bank bank = new Bank();
        Account savingsAccount = new SavingsAccount("1");
        bank.addCustomer(new Customer("Bill").openAccount(savingsAccount));

        savingsAccount.deposit(1500.0);

        assertEquals(2.0, bank.totalInterestPaid(), DOUBLE_DELTA);
    }

    @Test
    public void maxiSavingsAccount() {
        Bank bank = new Bank();
        Account maxiSavingsAccounts = new MaxiSavingsAccounts("1");
        bank.addCustomer(new Customer("Bill").openAccount(maxiSavingsAccounts));

        maxiSavingsAccounts.deposit(3000.0);

        assertEquals(170.0, bank.totalInterestPaid(), DOUBLE_DELTA);
    }
    
    @Test
    public void testAddCustomerWithOneCustomer(){
    	 Bank bank = new Bank();
         Account maxiSavingsAccounts = new MaxiSavingsAccounts("1");
         bank.addCustomer(new Customer("Bill").openAccount(maxiSavingsAccounts));
         
         assertEquals(1, bank.totalInterestPaid(), bank.getNumberOfCustomers());
    }
    
    @Test
    public void testAddCustomerWithTwoCustomer(){
    	 Bank bank = new Bank();
         Account maxiSavingsAccounts = new MaxiSavingsAccounts("1");
         bank.addCustomer(new Customer("Bill").openAccount(maxiSavingsAccounts));
         
         Account checkingAccount = new CheckingAccount("2");
         bank.addCustomer(new Customer("Billy").openAccount(checkingAccount));
         
         assertEquals(2, bank.totalInterestPaid(), bank.getNumberOfCustomers());
    }

}
