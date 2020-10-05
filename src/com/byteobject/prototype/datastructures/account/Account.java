package com.byteobject.prototype.datastructures.account;

public class Account {

    private int balance = 0;

    public synchronized String deposit(int money) {
        balance += money;
        return "Depositing " + money;
    }

    public synchronized String withdraw(int money) {
        String retVal = null;
        if (money > balance) {
            retVal = "Withdrawing " + money + " (Insufficient Balance)";
        } else {
            balance -= money;
            return "Withdrawing " + money;
        }

        return retVal;
    }

    public synchronized int getBalance() {
        return this.balance;
    }

}
