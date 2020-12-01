package com.gamesys.exercises.generics.inheritance.bank.core.transaction;

import java.math.BigDecimal;

public class Deposit implements Transaction, Debit {

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

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public BigDecimal getDebitAmount() {
        return amount;
    }

    @Override
    public String getSourceAccountNumber() {
        return accountNumber;
    }
}
