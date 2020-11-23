package com.gamesys.exercises.generics.inheritance.atm.main;

import com.gamesys.exercises.generics.inheritance.atm.core.AtmLogic;
import com.gamesys.exercises.generics.inheritance.atm.core.bank.BankGateway;
import com.gamesys.exercises.generics.inheritance.atm.core.input.UserInterface;
import com.gamesys.exercises.generics.inheritance.atm.infrastructure.bank.SimpleBankGateway;
import com.gamesys.exercises.generics.inheritance.atm.infrastructure.input.SimpleUserInterface;

import javax.swing.*;

public class AtmMain {

    public static void main(String[] args) {
        final BankGateway bankGateway = new SimpleBankGateway();
        final UserInterface userInterface = new SimpleUserInterface();
        final AtmLogic atmLogic = new AtmLogic(bankGateway, userInterface);

        int anotherTransaction;
        do {
            atmLogic.start();
            anotherTransaction = JOptionPane.showConfirmDialog(null, "Do you to start another transaction?",
                    "Another Transaction", JOptionPane.YES_NO_OPTION);
        } while (anotherTransaction == JOptionPane.YES_OPTION);
    }

}
