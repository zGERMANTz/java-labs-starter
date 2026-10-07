package edu.course.lab02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тесты для класса BankAccount.
 */
class BankAccountTest {

    @Test
    void testSuccessfulWithdraw() {
        BankAccount account = new BankAccount(1000);
        account.withdraw(500);
        assertEquals(500, account.getBalance());
    }

    @Test
    void testWithdrawExceedsBalance() {
        BankAccount account = new BankAccount(100);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(200));
    }

    @Test
    void testNegativeInitialBalance() {
        assertThrows(IllegalArgumentException.class, () -> new BankAccount(-100));
    }

    @Test
    void testZeroInitialBalance() {
        BankAccount account = new BankAccount(0);
        assertEquals(0, account.getBalance());
    }

    @Test
    void testSuccessfulDeposit() {
        BankAccount account = new BankAccount(100);
        account.deposit(50);
        assertEquals(150, account.getBalance());
    }

    @Test
    void testDepositNonPositiveAmount() {
        BankAccount account = new BankAccount(100);
        assertThrows(IllegalArgumentException.class, () -> account.deposit(0));
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-50));
    }

    @Test
    void testWithdrawNonPositiveAmount() {
        BankAccount account = new BankAccount(100);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(0));
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-50));
    }

    @Test
    void testMultipleOperations() {
        BankAccount account = new BankAccount(1000);
        account.deposit(500);
        account.withdraw(300);
        account.deposit(100);
        assertEquals(1300, account.getBalance());
    }
}
