package bank;

import java.util.Date;
import java.util.Stack;

public class BankAccount {

    private long balance;
    private long accountNumber;
    private Stack<Transaction> transactions = new Stack<>();

    public Stack<Transaction> getTransactionList() {
        return transactions;
    }

    public BankAccount(long balance, long accountNumber) {
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    synchronized void withdraw(long money) {
        if (getBalance() >= money) {
            balance -= money;

            Date now = new Date();
            Transaction transaction = new Transaction(now, (balance + money), -money);
            transactions.push(transaction);
        } else if (getBalance() > 0) {
            long draw = balance;
            balance -= getBalance();

            Date now = new Date();
            Transaction transaction = new Transaction(now, draw, -draw);
            transactions.push(transaction);
        }
    }

    synchronized void pay(long money) {
        balance += money;
    }

    synchronized long getBalance() {
        return balance;
    }
}
