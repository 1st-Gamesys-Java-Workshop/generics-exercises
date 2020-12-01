package com.gamesys.exercises.generics.inheritance.bank.core.transaction.handler;

import com.gamesys.exercises.generics.inheritance.bank.core.AccountService;
import com.gamesys.exercises.generics.inheritance.bank.core.transaction.FundTransfer;
import com.gamesys.exercises.generics.inheritance.bank.core.transaction.TransactionResult;

import java.math.BigDecimal;

public class FundTransferHandler implements TransactionHandler<FundTransfer> {

    private final AccountService accountService;

    public FundTransferHandler(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public TransactionResult handleTransaction(FundTransfer transaction) {
        if (transaction.getDebitAmount().compareTo(BigDecimal.ZERO) > 0 &&
                transaction.getCreditAmount().compareTo(BigDecimal.ZERO) > 0) {
            accountService.debit(transaction.getAccountNumber(), transaction.getDebitAmount());
            accountService.credit(transaction.getTargetAccountNumber(), transaction.getCreditAmount());
        }
        BigDecimal balance = accountService.getBalance(transaction.getSourceAccountNumber());
        return new TransactionResult(transaction.getTransactionId(), true, balance);
    }

}
