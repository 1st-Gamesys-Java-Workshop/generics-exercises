package com.gamesys.exercises.generics.inheritance.bank.core.transaction.handler;

import com.gamesys.exercises.generics.inheritance.bank.core.AccountService;
import com.gamesys.exercises.generics.inheritance.bank.core.transaction.Deposit;
import com.gamesys.exercises.generics.inheritance.bank.core.transaction.TransactionResult;

import java.math.BigDecimal;

public class DepositHandler implements TransactionHandler<Deposit> {

    private final AccountService accountService;

    public DepositHandler(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public TransactionResult handleTransaction(Deposit transaction) {
        accountService.credit(transaction.getAccountNumber(), transaction.getDebitAmount());
        BigDecimal balance = accountService.getBalance(transaction.getSourceAccountNumber());
        return new TransactionResult(transaction.getTransactionId(), true, balance);
    }

}
