package com.gamesys.exercises.generics.inheritance.bank.core;

import com.gamesys.exercises.generics.inheritance.bank.core.transaction.*;
import com.gamesys.exercises.generics.inheritance.bank.core.transaction.handler.BalanceInquiryHandler;
import com.gamesys.exercises.generics.inheritance.bank.core.transaction.handler.DepositHandler;
import com.gamesys.exercises.generics.inheritance.bank.core.transaction.handler.FundTransferHandler;
import com.gamesys.exercises.generics.inheritance.bank.core.transaction.handler.WithdrawalHandler;

public class Bank {

    private final BalanceInquiryHandler balanceInquiryHandler;
    private final DepositHandler depositHandler;
    private final WithdrawalHandler withdrawalHandler;
    private final FundTransferHandler fundTransferHandler;

    public Bank(BalanceInquiryHandler balanceInquiryHandler,
                DepositHandler depositHandler,
                WithdrawalHandler withdrawalHandler,
                FundTransferHandler fundTransferHandler) {
        this.balanceInquiryHandler = balanceInquiryHandler;
        this.depositHandler = depositHandler;
        this.withdrawalHandler = withdrawalHandler;
        this.fundTransferHandler = fundTransferHandler;
    }

    public TransactionResult balanceInquiry(BalanceInquiry balanceInquiry) {
        return balanceInquiryHandler.handleTransaction(balanceInquiry);
    }

    public TransactionResult deposit(Deposit deposit) {
        return depositHandler.handleTransaction(deposit);
    }

    public TransactionResult withdraw(Withdrawal withdrawal) {
        return withdrawalHandler.handleTransaction(withdrawal);
    }

    public TransactionResult fundTransfer(FundTransfer fundTransfer) {
        return fundTransferHandler.handleTransaction(fundTransfer);
    }

}
