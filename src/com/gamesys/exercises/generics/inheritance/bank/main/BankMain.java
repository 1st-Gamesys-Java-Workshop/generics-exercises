package com.gamesys.exercises.generics.inheritance.bank.main;

import com.gamesys.exercises.generics.inheritance.bank.core.AccountService;
import com.gamesys.exercises.generics.inheritance.bank.core.Bank;
import com.gamesys.exercises.generics.inheritance.bank.core.transaction.*;
import com.gamesys.exercises.generics.inheritance.bank.core.transaction.handler.BalanceInquiryHandler;
import com.gamesys.exercises.generics.inheritance.bank.core.transaction.handler.DepositHandler;
import com.gamesys.exercises.generics.inheritance.bank.core.transaction.handler.FundTransferHandler;
import com.gamesys.exercises.generics.inheritance.bank.core.transaction.handler.WithdrawalHandler;

import java.math.BigDecimal;

public class BankMain {

    public static void main(String[] args) {
        AccountService accountService = new FakeAccountService();

        BalanceInquiryHandler balanceInquiryHandler = new BalanceInquiryHandler(accountService);
        DepositHandler depositHandler = new DepositHandler(accountService);
        WithdrawalHandler withdrawalHandler = new WithdrawalHandler(accountService);
        FundTransferHandler fundTransferHandler = new FundTransferHandler(accountService);

        Bank bank = new Bank(balanceInquiryHandler, depositHandler, withdrawalHandler, fundTransferHandler);

        String account1 = "0001234567";
        String account2 = "0001234600";

        System.out.println("Balance Inquiry...");
        TransactionResult result = bank.balanceInquiry(new BalanceInquiry(account1));
        System.out.println(result);

        System.out.println("\nDeposit Amount...");
        result = bank.deposit(new Deposit(account1, new BigDecimal("100.0")));
        System.out.println(result);

        System.out.println("\nWithdraw Amount...");
        result = bank.withdraw(new Withdrawal(account1, new BigDecimal("15.0")));
        System.out.println(result);

        System.out.println("\nFund Transfer...");
        result = bank.fundTransfer(new FundTransfer(account1, account2, new BigDecimal("25.0")));
        System.out.println(result);
    }

}
