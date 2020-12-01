package com.gamesys.exercises.generics.inheritance.bank.core.transaction.handler;

import com.gamesys.exercises.generics.inheritance.bank.core.AccountService;
import com.gamesys.exercises.generics.inheritance.bank.core.transaction.BalanceInquiry;
import com.gamesys.exercises.generics.inheritance.bank.core.transaction.TransactionResult;

import java.math.BigDecimal;

public class BalanceInquiryHandler implements TransactionHandler<BalanceInquiry> {

    private final AccountService accountService;

    public BalanceInquiryHandler(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public TransactionResult handleTransaction(BalanceInquiry transaction) {
        BigDecimal balance = accountService.getBalance(transaction.getAccountNumber());
        return new TransactionResult(transaction.getTransactionId(), true, balance);
    }

}
