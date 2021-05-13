package com.revature.intro.services;

import com.revature.intro.Screens.LoginScreen;
import com.revature.intro.exceptions.BankAccountException;
import com.revature.intro.models.AppUser;

import java.text.NumberFormat;


public class BankAccount {
    /**
     *Does calculations to check users account balance.
     *
     */

    private double balance; //set equal
    // Constructor -- set the initial state

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        if(balance == 0)
            System.out.println("Seems like your balance is low, we suggest making a deposit before moving forward...");
        return balance;

    }//use for transactions may be unnecessary

    public String currentBalance() {
        return "Balance: " + balance;
    } // to print.


    public void deposit(double amount) {
        if (amount >= 0)
            balance = balance + amount;

        else
            throw new BankAccountException("Negative deposits are not allowed!");
    }// allow amount do be what was read in entry.

    public void withdraw(double amount) {
        if (amount >= 0) {
            if (balance >= amount) {
                balance = balance - amount;

            }else {
                throw new BankAccountException("Insufficient funds! Cannot withdraw!");
            }
        } else {
            throw new BankAccountException("Negative withdrawals are not allowed!");
        }
    }

}