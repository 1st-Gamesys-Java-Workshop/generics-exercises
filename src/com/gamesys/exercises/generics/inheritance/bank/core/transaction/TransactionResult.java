package com.gamesys.exercises.generics.inheritance.bank.core.transaction;

import java.math.BigDecimal;

public class TransactionResult {

    private final String transactionId;
    private final boolean successful;
    private final BigDecimal balance;

    public TransactionResult(String transactionId, boolean successful, BigDecimal balance) {
        this.transactionId = transactionId;
        this.successful = successful;
        this.balance = balance;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
