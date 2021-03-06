package com.abc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    @Test //Test customer statement generation
    public void testApp(){

        Account checkingAccount = new CheckingAccount("1");
        Account savingsAccount = new SavingsAccount("2");

        Customer henry = new Customer("Henry").openAccount(checkingAccount).openAccount(savingsAccount);

        checkingAccount.deposit(100.0);
        savingsAccount.deposit(4000.0);
        savingsAccount.withdraw(200.0);
       

        assertEquals("Statement for Henry\n" +
                "\n" +
                "Checking Account\n" +
                "  deposit $100.00\n" +
                "Total $100.00\n" +
                "\n" +
                "Savings Account\n" +
                "  deposit $4,000.00\n" +
                "  withdrawal $200.00\n" +
                "Total $3,800.00\n" +
                "\n" +
                "Total In All Accounts $3,900.00", henry.getStatement());
    }

    @Test
    public void testOneAccount(){
        Customer oscar = new Customer("Oscar").openAccount(new SavingsAccount("1"));
        assertEquals(1, oscar.getNumberOfAccounts());
    }

    @Test
    public void testTwoAccount(){
        Customer oscar = new Customer("Oscar")
                .openAccount(new SavingsAccount("1"));
        oscar.openAccount(new CheckingAccount("2"));
        assertEquals(2, oscar.getNumberOfAccounts());
    }

    @Test
    public void testThreeAcounts() {
        Customer oscar = new Customer("Oscar")
                .openAccount(new SavingsAccount("1"));
        oscar.openAccount(new CheckingAccount("2"));
        oscar.openAccount(new CheckingAccount("3"));
        assertEquals(3, oscar.getNumberOfAccounts());
    }
    
    @Test
    public void testFindAccount(){
    	Account checkingAccount = new CheckingAccount("1");
        Account savingsAccount = new SavingsAccount("2");

        Customer henry = new Customer("Henry").openAccount(checkingAccount).openAccount(savingsAccount);
        
        assertEquals("1", henry.findAccount("1").getAccountId());

    }
    
    @Test(expected = NullPointerException.class)
    public void testFindAccountWithNonExistingAccount(){
    	Account checkingAccount = new CheckingAccount("1");
        Account savingsAccount = new SavingsAccount("2");

        Customer henry = new Customer("Henry").openAccount(checkingAccount).openAccount(savingsAccount);
        
        assertEquals("1", henry.findAccount("3").getAccountId());

    }
    
    @Test(expected = NullPointerException.class)
    public void testTransferMoneyWithInvalidAccounts(){
    	Account checkingAccount = new CheckingAccount("1");
        Account savingsAccount = new SavingsAccount("2");

        Customer henry = new Customer("Henry").openAccount(checkingAccount).openAccount(savingsAccount);
        
        henry.transferMoney("5", "6", 100.0);
    }
    
    @Test(expected = NullPointerException.class)
    public void testTransferMoneyWithInvalidAccount(){
    	Account checkingAccount = new CheckingAccount("1");
        Account savingsAccount = new SavingsAccount("2");

        Customer henry = new Customer("Henry").openAccount(checkingAccount).openAccount(savingsAccount);
        
        henry.transferMoney("1", "6", 100.0);
    }
    
    @Test
    public void testTransferMoney(){
    	Account checkingAccount = new CheckingAccount("1");
        Account savingsAccount = new SavingsAccount("2");
        
        savingsAccount.deposit(100.0);
        checkingAccount.deposit(100.0);

        Customer henry = new Customer("Henry").openAccount(checkingAccount).openAccount(savingsAccount);
        henry.transferMoney(savingsAccount.getAccountId(), checkingAccount.getAccountId(), 50.0);
        assertEquals(new Double(50.0), savingsAccount.sumTransactions());
        assertEquals(new Double(150.0), checkingAccount.sumTransactions());
    }
    
}
