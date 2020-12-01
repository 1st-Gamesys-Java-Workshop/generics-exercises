package com.gamesys.exercises.generics.inheritance.bank.core;

import java.math.BigDecimal;

public interface AccountService {

    BigDecimal getBalance(String accountNumber);

    void deposit(String accountNumber, BigDecimal amount);

    void withdraw(String accountNumber, BigDecimal amount);

}
