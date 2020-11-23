package com.gamesys.exercises.generics.inheritance.atm.core.bank;

import com.gamesys.exercises.generics.inheritance.atm.core.bank.transaction.Transaction;

import java.math.BigDecimal;

public interface BankGateway {

    Transaction createNewTransaction(String cardNumber);

    boolean isValidPin(String pin, Transaction transaction);

    BigDecimal inquireBalance(Transaction transaction);

    void creditAccount(BigDecimal amount, Transaction transaction);

    void debitAccount(BigDecimal amount, Transaction transaction);

}
