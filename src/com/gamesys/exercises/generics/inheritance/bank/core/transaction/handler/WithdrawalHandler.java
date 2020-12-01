package com.gamesys.exercises.generics.inheritance.bank.core.transaction.handler;

import com.gamesys.exercises.generics.inheritance.bank.core.AccountService;
import com.gamesys.exercises.generics.inheritance.bank.core.transaction.TransactionResult;
import com.gamesys.exercises.generics.inheritance.bank.core.transaction.Withdrawal;

import java.math.BigDecimal;

public class WithdrawalHandler implements TransactionHandler<Withdrawal> {

    private final AccountService accountService;

    public WithdrawalHandler(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public TransactionResult handleTransaction(Withdrawal transaction) {
        accountService.debit(transaction.getAccountNumber(), transaction.getAmount());
        BigDecimal balance = accountService.getBalance(transaction.getAccountNumber());
        return new TransactionResult(transaction.getTransactionId(), true, balance);
    }

}
