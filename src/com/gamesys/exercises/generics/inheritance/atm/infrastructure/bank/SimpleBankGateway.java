package com.gamesys.exercises.generics.inheritance.atm.infrastructure.bank;

import com.gamesys.exercises.generics.inheritance.atm.core.bank.BankGateway;
import com.gamesys.exercises.generics.inheritance.atm.core.bank.transaction.Transaction;

import java.math.BigDecimal;
import java.util.UUID;

public class SimpleBankGateway implements BankGateway {

    private static Account dummyAccount = new Account(new BigDecimal("10000"), "1234");

    @Override
    public Transaction createNewTransaction(String cardNumber) {
        return new Transaction(UUID.randomUUID().toString());
    }

    @Override
    public boolean isValidPin(String pin, Transaction transaction) {
        return dummyAccount.getPin().equals(pin);
    }

    @Override
    public BigDecimal inquireBalance(Transaction transaction) {
        return dummyAccount.getAvailableBalance();
    }

    @Override
    public void creditAccount(BigDecimal amount, Transaction transaction) {
        BigDecimal availableBalance = inquireBalance(transaction);
        dummyAccount.setAvailableBalance(availableBalance.add(amount));
    }

    @Override
    public void debitAccount(BigDecimal amount, Transaction transaction) {
        BigDecimal availableBalance = inquireBalance(transaction);
        dummyAccount.setAvailableBalance(availableBalance.min(amount));
    }

    private static class Account {
        private BigDecimal availableBalance;
        private String pin;

        public Account(BigDecimal availableBalance, String pin) {
            this.availableBalance = availableBalance;
            this.pin = pin;
        }

        public BigDecimal getAvailableBalance() {
            return availableBalance;
        }

        public String getPin() {
            return pin;
        }

        public void setAvailableBalance(BigDecimal availableBalance) {
            this.availableBalance = availableBalance;
        }
    }
}
