package com.gamesys.exercises.generics.inheritance.bank.core.transaction;

import java.math.BigDecimal;
import java.util.UUID;

public class FundTransfer implements Transaction, Debit, Credit {

    private final String transactionId;
    private final String sourceAccountNumber;
    private final String targetAccountNumber;
    private final BigDecimal amount;

    public FundTransfer(String sourceAccountNumber, String targetAccountNumber, BigDecimal amount) {
        this.transactionId = UUID.randomUUID().toString();
        this.sourceAccountNumber = sourceAccountNumber;
        this.targetAccountNumber = targetAccountNumber;
        this.amount = amount;
    }

    @Override
    public String getTransactionId() {
        return transactionId;
    }

    @Override
    public String getAccountNumber() {
        return sourceAccountNumber;
    }

    @Override
    public BigDecimal getCreditAmount() {
        return amount;
    }

    @Override
    public String getTargetAccountNumber() {
        return targetAccountNumber;
    }

    @Override
    public BigDecimal getDebitAmount() {
        return amount;
    }

    @Override
    public String getSourceAccountNumber() {
        return sourceAccountNumber;
    }
}
