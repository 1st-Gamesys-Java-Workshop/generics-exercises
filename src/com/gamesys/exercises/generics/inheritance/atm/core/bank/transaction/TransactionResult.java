package com.gamesys.exercises.generics.inheritance.atm.core.bank.transaction;

import java.math.BigDecimal;

public class TransactionResult {

    private final TransactionStatus status;
    private final BigDecimal availableBalance;

    public TransactionResult(TransactionStatus status) {
        this.status = status;
        availableBalance = BigDecimal.ZERO;
    }

    public TransactionResult(TransactionStatus status, BigDecimal availableBalance) {
        this.status = status;
        this.availableBalance = availableBalance;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public BigDecimal getAvailableBalance() {
        return availableBalance;
    }
}
