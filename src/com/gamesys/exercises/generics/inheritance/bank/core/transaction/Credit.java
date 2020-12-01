package com.gamesys.exercises.generics.inheritance.bank.core.transaction;

import java.math.BigDecimal;

public interface Credit {

    BigDecimal getCreditAmount();

    String getTargetAccountNumber();

}
