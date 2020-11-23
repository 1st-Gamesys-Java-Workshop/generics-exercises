package com.gamesys.exercises.generics.inheritance.atm.infrastructure.input;

import com.gamesys.exercises.generics.inheritance.atm.core.bank.transaction.Transaction;
import com.gamesys.exercises.generics.inheritance.atm.core.bank.transaction.TransactionResult;
import com.gamesys.exercises.generics.inheritance.atm.core.bank.transaction.TransactionType;
import com.gamesys.exercises.generics.inheritance.atm.core.input.UserInterface;

import javax.swing.*;
import java.math.BigDecimal;

public class SimpleUserInterface implements UserInterface {

    // This is for demo purpose only. Please do not hardcode data.
    private static final String CARD_NUMBER = "5432123456789012";

    @Override
    public String askToInsertCard() {
        JOptionPane.showMessageDialog(null, "Please insert ATM Card");
        return CARD_NUMBER;
    }

    @Override
    public String askForPin() {
        return JOptionPane.showInputDialog(null, "Please input PIN");
    }

    @Override
    public TransactionType askForTransactionType() {
        Object[] transactionTypes = new Object[] {
                TransactionType.BALANCE_INQUIRY,
                TransactionType.DEPOSIT,
                TransactionType.WITHDRAWAL
        };
        return (TransactionType) JOptionPane.showInputDialog(null, "Please choose a transaction type", "Transaction Type",
                JOptionPane.PLAIN_MESSAGE, null, transactionTypes, TransactionType.BALANCE_INQUIRY);
    }

    @Override
    public BigDecimal askForAmount() {
        String amountString = JOptionPane.showInputDialog(null, "Please input amount");
        return new BigDecimal(amountString);
    }

    @Override
    public String askForTargetAccountNumber() {
        return JOptionPane.showInputDialog(null, "Please input target amount");
    }

    @Override
    public void displayTransactionResult(Transaction transaction) {
        TransactionResult transactionResult = transaction.getResult();
        JOptionPane.showMessageDialog(null,
                "Status: " + transactionResult.getStatus() +
                "\nAvailable Balance: " + transactionResult.getAvailableBalance().toString());
    }
}
