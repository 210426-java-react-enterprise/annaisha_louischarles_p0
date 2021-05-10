package com.revature.intro.util;

import com.revature.intro.Screens.Screen;
import com.revature.intro.daos.UserDao;
import com.revature.intro.exceptions.*;

import java.io.BufferedReader;
import java.text.NumberFormat;

public class BankAccount extends Screen {

    private double balance;
    private BufferedReader br;

    // Constructor -- set the initial state

    public BankAccount(BufferedReader br, ScreenRouter router) {
        super("BankAccountScreen", "/account");
        this.br = br;
    }


    public BankAccount(BufferedReader br, ScreenRouter router, double initialDeposit) {
        super("BankAccountScreen", "/account");
        this.br = br;
        this.balance = initialDeposit;
    }

    public double getBalance() {
        return balance;
    }

    public String getFormattedBalance() {
        NumberFormat numF = NumberFormat.getCurrencyInstance();

        return "Your balance is:  " + numF.format(balance);
    }

    @Override
    public String toString() {
        return "Balance: " + balance;
    }


    public void deposit(double amount) {
        if (amount >= 0)
            balance = balance + amount;

        else
            throw new BankAccountException("Negative deposits are not allowed!");
    }

    public void withdraw(double amount) {
        if (amount >= 0) {
            if (balance >= amount)
                balance = balance - amount;
            else
                throw new BankAccountException("Insufficient funds! Cannot withdraw!");
        } else
            throw new BankAccountException("Negative withdrawals are not allowed!");
    }

    @Override
    public void render() {

    }
}