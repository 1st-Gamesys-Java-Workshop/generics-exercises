package com.gamesys.exercises.generics.inheritance.bank.main;

import com.gamesys.exercises.generics.inheritance.bank.core.AccountService;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * This is just a demo.
 * Please don't use in production :)
 */
public class FakeAccountService implements AccountService {

    private static final Map<String, BigDecimal> accounts;

    static {
        accounts = new HashMap<>();
    }

    @Override
    public BigDecimal getBalance(String accountNumber) {
        return accounts.getOrDefault(accountNumber, BigDecimal.ZERO);
    }

    @Override
    public void credit(String accountNumber, BigDecimal amount) {
        BigDecimal balance = getBalance(accountNumber);
        balance = balance.add(amount);
        accounts.put(accountNumber, balance);
    }

    @Override
    public void debit(String accountNumber, BigDecimal amount) {
        BigDecimal balance = getBalance(accountNumber);
        balance = balance.subtract(amount);
        accounts.put(accountNumber, balance);
    }
}
