package com.gamesys.exercises.generics.inheritance.bank.core.transaction;

import java.math.BigDecimal;

public interface Debit {

    BigDecimal getDebitAmount();

    String getSourceAccountNumber();

}
