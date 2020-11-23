package com.gamesys.exercises.generics.inheritance.atm.core;

import com.gamesys.exercises.generics.inheritance.atm.core.bank.BankGateway;
import com.gamesys.exercises.generics.inheritance.atm.core.bank.transaction.Transaction;
import com.gamesys.exercises.generics.inheritance.atm.core.bank.transaction.TransactionResult;
import com.gamesys.exercises.generics.inheritance.atm.core.bank.transaction.TransactionStatus;
import com.gamesys.exercises.generics.inheritance.atm.core.bank.transaction.TransactionType;
import com.gamesys.exercises.generics.inheritance.atm.core.input.UserInterface;

import java.math.BigDecimal;

public class AtmLogic {

    private final BankGateway bankGateway;
    private final UserInterface userInterface;

    public AtmLogic(BankGateway bankGateway, UserInterface userInterface) {
        this.bankGateway = bankGateway;
        this.userInterface = userInterface;
    }

    public void start() {
        // Start a new transaction
        String cardNumber = userInterface.askToInsertCard();
        Transaction transaction = bankGateway.createNewTransaction(cardNumber);

        // Validate PIN
        String pin;
        int pinValidationAttempts = 0;
        do {
            if (pinValidationAttempts == 3) {
                transaction.setResult(new TransactionResult(TransactionStatus.CARD_BLOCKED));
                break;
            }
            pin = userInterface.askForPin();
            pinValidationAttempts++;
        } while (!bankGateway.isValidPin(pin, transaction));

        if (transaction.getResult() == null || !TransactionStatus.CARD_BLOCKED.equals(transaction.getResult().getStatus())) {
            TransactionType transactionType = userInterface.askForTransactionType();
            transaction.setType(transactionType);

            // Perform Transaction Proper
            BigDecimal availableBalance;
            BigDecimal amount;

            switch (transactionType) {
                case BALANCE_INQUIRY:
                    availableBalance = bankGateway.inquireBalance(transaction);
                    transaction.setResult(new TransactionResult(TransactionStatus.SUCCESSFUL, availableBalance));
                    break;
                case DEPOSIT:
                    amount = userInterface.askForAmount();
                    transaction.setAmount(amount);
                    bankGateway.creditAccount(amount, transaction);
                    availableBalance = bankGateway.inquireBalance(transaction);
                    transaction.setResult(new TransactionResult(TransactionStatus.SUCCESSFUL, availableBalance));
                    break;
                case WITHDRAWAL:
                    amount = userInterface.askForAmount();
                    transaction.setAmount(amount);
                    bankGateway.debitAccount(amount, transaction);
                    availableBalance = bankGateway.inquireBalance(transaction);
                    transaction.setResult(new TransactionResult(TransactionStatus.SUCCESSFUL, availableBalance));
                    break;
                default:
            }
        }

        // Display Result
        userInterface.displayTransactionResult(transaction);
    }

}
