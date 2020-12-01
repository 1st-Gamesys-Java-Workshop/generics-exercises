package com.gamesys.exercises.generics.inheritance.bank.core.transaction;

import java.math.BigDecimal;

public class FundTransfer implements Transaction {

    private final String transactionId;
    private final String sourceAccountNumber;
    private final String targetAccountNumber;
    private final BigDecimal amount;

    public FundTransfer(String transactionId, String sourceAccountNumber, String targetAccountNumber, BigDecimal amount) {
        this.transactionId = transactionId;
        this.sourceAccountNumber = sourceAccountNumber;
        this.targetAccountNumber = targetAccountNumber;
        this.amount = amount;
    }

    @Override
    public String getTransactionId() {
        return transactionId;
    }

    public String getSourceAccountNumber() {
        return sourceAccountNumber;
    }

    public String getTargetAccountNumber() {
        return targetAccountNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
