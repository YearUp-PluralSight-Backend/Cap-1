package com.pluralsight;

import java.io.*;
import java.util.*;
import static com.pluralsight.AccountingLedgerApp.homeScreen;

/*This is the Reader Class
Here is where my buffered/file reader is stored
When launched, my main method will start the readTransactions method automatically
 */
public class Reader {
    public static ArrayList<Transaction> transactionList = new ArrayList<>();

    public static void readTransactions() throws IOException {
        FileReader fileReader = new FileReader("transactions.csv");
        BufferedReader bufReader = new BufferedReader(fileReader);
        String csv;
        while ((csv = bufReader.readLine()) != null) {
            String[] transactionLedger = csv.split("\\|");
            if (!transactionLedger[0].contains("date")) {
                String date = transactionLedger[0];
                //String time = transactionLedger[1];
                String time = "";
                if (transactionLedger.length > 1) {
                    time = transactionLedger[1];
                } else {
                    System.out.println("Transaction ledger has insufficient data.");

                    String desc = transactionLedger[2];
                    String vendor = transactionLedger[3];
                    float amount = Float.parseFloat(transactionLedger[4]);
                    Transaction newTransaction = new Transaction(date, time, desc, vendor, amount);
                    transactionList.add(newTransaction);
                }

            }

            transactionList.forEach(System.out::println);

            homeScreen();
            fileReader.close();
            bufReader.close();
        }
    }

    public static void saveTransaction() throws IOException{

        FileWriter fileWriter = new FileWriter("transactions.csv");
        BufferedWriter buffWriter = new BufferedWriter(fileWriter);

        buffWriter.write("date|time|description|vendor|amount \n"); // header

        for (Transaction t : transactionList) {

            String data = t.getDate() + t.getTime() + t.getDesc() + t.getVendor() + t.getAmount() + '\n';
            buffWriter.write(data);
        }
        buffWriter.close();

    }
}