package com.revature.intro.Screens;

import com.revature.intro.exceptions.BankAccountException;
import com.revature.intro.exceptions.InvalidRequestException;
import com.revature.intro.exceptions.ResourcePersistenceException;
import com.revature.intro.models.AppUser;
import com.revature.intro.util.BankAccount;
import com.revature.intro.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import static com.revature.intro.Driver.getApp;

public class TransactionScreen extends Screen {
    // Class Variables

    BufferedReader br;
    ScreenRouter router;
    BankAccount bankAccount;

    public TransactionScreen(BufferedReader br, ScreenRouter router, BankAccount bankAccount) {
        super("Transaction Screen", "/transaction");
        this.br = br;
        this.router = router;
        this.bankAccount = bankAccount;
    }

    public TransactionScreen(BufferedReader br, ScreenRouter router) {
        super("Transaction Screen", "/transaction");
        this.br = br;
        this.router = router;
    }

<<<<<<< HEAD
=======
    public void displayMenu() {
        System.out.println("\n----- Bank Account Menu ----\n");
        System.out.println("   1. Get balance");
        System.out.println("   2. Deposit");
        System.out.println("   3. Withdraw");
        System.out.println("   4. Display menu");
        System.out.println("   5  Exit menu");
    }

>>>>>>> a810b6d56a64f769524cce173fbb1cacab1d3173

    @Override
    public void render() {

        System.out.println("\n----- Bank Account Menu ----\n");
        System.out.println("   1. Get balance");
        System.out.println("   2. Deposit");
        System.out.println("   3. Withdraw");
        System.out.println("   4.  Exit menu");

        try {
            System.out.println(">>");
            String userSelection = br.readLine();

            switch (userSelection) {
                case "1":
                    System.out.println("Current Balance:  ");
                    System.out.println(bankAccount.getFormattedBalance());
                    break;

                case "2":
                    processDeposit();
                    // processDeposit(Double.valueOf(br.readLine())); //not good
                    break;

                case "3":
                    processWithdrawal();
                    System.out.println("How much would you like to withdraw? ");
                    break;

                case "4":
                    System.out.println("Exiting application, Goodbye and Have a MARVELous day!");
                    System.out.println("+----------------------------------+");
                    getApp().setAppRunning(false); //will close application properly! Then the render method will be done.
                    //After this render method is complete, it will loop back to Driver under the "while(app.isAppRunning)
                    //which would have been fulfilled and ended. now main method is over.
                    break;
                default:
                    System.out.println("We know heroes can do extraordinary things, but this was an ordinary Invalid selection! ");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void processWithdrawal() {
        //to be done.

    }

    private void processDeposit() {
        double depositAmount = 0.0;
        String strDeposit = null;

        System.out.println("How much would you like to deposit? ");

        try {
            System.out.print("\nEnter deposit: ");
            strDeposit = br.readLine();
            depositAmount = Double.parseDouble(strDeposit); //may change later

            // call bankAccount to make deposit

            bankAccount.deposit(depositAmount);


        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        } catch (BankAccountException e) {
            System.out.println(e.getMessage());
        }
    }
}

