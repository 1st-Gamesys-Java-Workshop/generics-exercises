package com.gamesys.exercises.generics.inheritance.atm.core.input;

import com.gamesys.exercises.generics.inheritance.atm.core.bank.transaction.Transaction;
import com.gamesys.exercises.generics.inheritance.atm.core.bank.transaction.TransactionType;

import java.math.BigDecimal;

public interface UserInterface {

    String askToInsertCard();

    String askForPin();

    TransactionType askForTransactionType();

    BigDecimal askForAmount();

    String askForTargetAccountNumber();

    void displayTransactionResult(Transaction transaction);

}
