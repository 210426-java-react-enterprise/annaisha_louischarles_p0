package com.revature.intro.Screens;

import com.revature.intro.daos.UserDao;
import com.revature.intro.exceptions.BankAccountException;
import com.revature.intro.services.BankAccount;
import com.revature.intro.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.NumberFormat;

import static com.revature.intro.Driver.getApp;

public class TransactionScreen extends Screen {
    /**
     * The screen is for the user to choose transaction options for navigation, as well as
     * defining the corresponding methods to be invoked
     *
     */

    BufferedReader br;
    ScreenRouter router;
    BankAccount bankAccount;
    UserDao userDao = new UserDao();
    NumberFormat formatter = NumberFormat.getCurrencyInstance();


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


    @Override
    public void render() {
        bankAccount = new BankAccount(userDao.getBal(String.valueOf(LoginScreen.currentUser.getCustomerId())));
        if(bankAccount.getBalance() == -1){
            System.out.println("Account does not exist");
            return;
        }
        System.out.println("Welcome back Hero! What would you like to do today?");
        System.out.println("\n----- Bank Account Menu ----\n");
        System.out.println("   1. Get balance");
        System.out.println("   2. Deposit");
        System.out.println("   3. Withdraw");
        System.out.println("   4. Exit menu");

        try {
            System.out.println(">>");
            String userSelection = br.readLine();

            switch (userSelection) {
                case "1":
                    System.out.println("Current Balance:  ");
                    processGetBal();
                    break;

                case "2":
                    processDeposit();
                    processGetBal();
                    // processDeposit(Double.valueOf(br.readLine())); //not good
                    break;

                case "3":
                    processWithdrawal();
                    processGetBal();
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
            userDao.update(String.valueOf(LoginScreen.currentUser.getCustomerId()), bankAccount.getBalance());

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        } catch (BankAccountException e) {
            System.out.println(e.getMessage());
        }
    }

    private void processGetBal() {
        try {
            double bal = userDao.getBal(String.valueOf(LoginScreen.currentUser.getCustomerId()));
            System.out.println("Your balance is: " + formatter.format(bal));
            render();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void processWithdrawal() {
        double withdrawalAmount = 0.0;
        String strWithdrawal = null;

        System.out.println("How much would you like to withdraw?");

        try {
            System.out.println("\n Enter withdrawal amount:");
            strWithdrawal = br.readLine();
            withdrawalAmount = Double.parseDouble((strWithdrawal));
            bankAccount.withdraw(withdrawalAmount);

            userDao.update(String.valueOf(LoginScreen.currentUser.getCustomerId()), bankAccount.getBalance());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        } catch (BankAccountException e) {
            System.out.println(e.getMessage());

        }
    }
}


