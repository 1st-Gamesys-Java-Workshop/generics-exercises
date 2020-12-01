package com.gamesys.exercises.generics.inheritance.bank.core.transaction;

import java.math.BigDecimal;
import java.util.UUID;

public class Withdrawal implements Transaction, Debit {

    private final String transactionId;
    private final String accountNumber;
    private final BigDecimal amount;

    public Withdrawal(String accountNumber, BigDecimal amount) {
        this.transactionId = UUID.randomUUID().toString();
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
