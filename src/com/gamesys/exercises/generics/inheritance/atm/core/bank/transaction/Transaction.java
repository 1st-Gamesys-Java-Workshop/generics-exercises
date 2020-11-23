package com.gamesys.exercises.generics.inheritance.atm.core.bank.transaction;

import java.math.BigDecimal;

public class Transaction {

    private final String id;
    private TransactionType type;
    private BigDecimal amount;
    private String targetAccountNumber;
    private TransactionResult result;

    public Transaction(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getTargetAccountNumber() {
        return targetAccountNumber;
    }

    public void setTargetAccountNumber(String targetAccountNumber) {
        this.targetAccountNumber = targetAccountNumber;
    }

    public TransactionResult getResult() {
        return result;
    }

    public void setResult(TransactionResult result) {
        this.result = result;
    }
}
