package com.gamesys.exercises.generics.inheritance.bank.core.transaction;

import java.math.BigDecimal;

public class Deposit implements Transaction {

    private final String transactionId;
    private final String accountNumber;
    private final BigDecimal amount;

    public Deposit(String transactionId, String accountNumber, BigDecimal amount) {
        this.transactionId = transactionId;
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    @Override
    public String getTransactionId() {
        return transactionId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
