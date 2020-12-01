package com.gamesys.exercises.generics.inheritance.bank.core;

import java.math.BigDecimal;

public interface AccountService {

    BigDecimal getBalance(String accountNumber);

    void credit(String accountNumber, BigDecimal amount);

    void debit(String accountNumber, BigDecimal amount);

}
