package com.byteobject.prototype.datastructures.account;

import java.util.ArrayList;
import java.util.List;

public class Transaction {

    private List<String> transactions = new ArrayList<>();

    private Account account;

    public void deposit(int money) {
        transactions.add(account.deposit(money));
    }

    public void withdraw(int money) {
        transactions.add(account.withdraw(money));
    }

    public List<String> getTransactions() {
        return this.transactions;
    }

}
