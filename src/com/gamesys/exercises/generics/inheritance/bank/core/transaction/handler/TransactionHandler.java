package com.gamesys.exercises.generics.inheritance.bank.core.transaction.handler;

import com.gamesys.exercises.generics.inheritance.bank.core.transaction.TransactionResult;

public interface TransactionHandler<T> {

    TransactionResult handleTransaction(T transaction);

}
