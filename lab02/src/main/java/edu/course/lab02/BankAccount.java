package edu.course.lab02;

/**
 * Учебный класс банковского счета с защитой инвариантов.
 */
public class BankAccount {

    private int balance;

    /**
     * Создает банковский счет с начальным балансом.
     *
     * @param initialBalance начальный баланс
     * @throws IllegalArgumentException если начальный баланс отрицательный
     */
    public BankAccount(int initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Начальный баланс не может быть отрицательным");
        }
        this.balance = initialBalance;
    }

    /**
     * Пополняет счет на указанную сумму.
     *
     * @param amount сумма пополнения
     * @throws IllegalArgumentException если сумма не положительная
     */
    public void deposit(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма пополнения должна быть положительной");
        }
        balance += amount;
    }

    /**
     * Снимает со счета указанную сумму.
     *
     * @param amount сумма для снятия
     * @throws IllegalArgumentException если сумма не положительная или превышает баланс
     */
    public void withdraw(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма снятия должна быть положительной");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Недостаточно средств на счете");
        }
        balance -= amount;
    }

    /**
     * Возвращает текущий баланс счета.
     *
     * @return текущий баланс
     */
    public int getBalance() {
        return balance;
    }
}
