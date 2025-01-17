package com.pluralsight;
import java.io.IOException;
import java.util.*;

import static com.pluralsight.AccountingLedgerApp.*;
import static com.pluralsight.Reader.transactionList;

/*This is my LedgerFunctions class
In this class you'll find the following functions:
displayAll();
displayDeposits();
displayPayments();
 */

public class LedgerFunctions {

    public static void displayAll() throws IOException {
        System.out.println("=======Transaction History=======");
        System.out.println("Number of Transactions: " + transactionList.size());
        System.out.println("\nDate       | Time       | Description                                | Vendor          | Amount");
        System.out.println("-----------+------------+--------------------------------------------+----------------+---------");

        for(Transaction transaction : transactionList){
            System.out.println(transaction.toString());
        }

        System.out.println("\nPress 'X' when you're ready to return to the Ledger menu");

        while(true){
            String exit = scanner.nextLine().toUpperCase().trim();

            if(exit.equals("X")){
                System.out.println("Returning to the Ledger menu.....");
                ledgerScreen();
                break;
            }else{
                System.out.println("Invalid input please enter 'X' to go back.");
            }
        }

//        System.out.println("Number of transactions: " + transactionList.size());
//        System.out.println("All Transaction History:");
//        for (Transaction trans : transactionList) { //CALLING THE DATA
//
//            System.out.println(trans.toString());
//
//
//
//        }
//        System.out.println("Press 'X' when you're ready to return to the Ledger menu");
//        String exit = scanner.nextLine().toUpperCase().trim();
//        if (exit.equals("X")) {
//            System.out.println("Redirecting to Ledger menu...");
//            ledgerScreen();
//        } else {
//            System.out.println("Sorry, ERROR. Press 'X' to return to the Ledger Menu");
//            displayAll();
//        }
    }

    public static void displayDeposits() throws IOException {
        System.out.println("All Deposit History:");
        for (Transaction trans : transactionList) {
            if (trans.getAmount() > 0) {
                System.out.println(trans.toString());
            }
        }
        System.out.println("Press 'X' when you're ready to return to the Ledger menu");
        String exit = scanner.nextLine().toUpperCase().trim();
        if (exit.equals("X")) {
            System.out.println("Redirecting to Ledger menu...");
            ledgerScreen();
        } else {
            System.out.println("Sorry, ERROR. Press 'X' to return to the Ledger Menu");
            displayDeposits();
        }
    }

    public static void displayPayments() throws IOException {
        System.out.println("All Payment History:");
        for (Transaction trans : transactionList) {
            if (trans.getAmount() < 0) {
                System.out.println(trans.toString());
            }
        }
        System.out.println("Press 'X' when you're ready to return to the Ledger menu");
        String exit = scanner.nextLine().toUpperCase().trim();
        if (exit.equals("X")) {
            System.out.println("Redirecting to Ledger menu...");
            ledgerScreen();
        } else {
            System.out.println("Sorry, ERROR Press 'X' to return to the Ledger Menu");
            displayPayments();
        }
    }
}