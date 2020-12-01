package com.gamesys.exercises.generics.inheritance.bank.core.transaction;

import java.util.UUID;

public class BalanceInquiry implements Transaction {

    private final String transactionId;
    private final String accountNumber;

    public BalanceInquiry(String accountNumber) {
        this.transactionId = UUID.randomUUID().toString();
        this.accountNumber = accountNumber;
    }

    @Override
    public String getTransactionId() {
        return transactionId;
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }
}
