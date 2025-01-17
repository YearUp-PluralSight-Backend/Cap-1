package com.pluralsight;

import java.time.format.DateTimeFormatter;

/*This is the Transaction class
Serves as a way to get and set date|time|description|vendor|amount
 */
@SuppressWarnings({"FieldMayBeFinal", "unused"})
public class Transaction {

    private String date;
    private String time;
    private String desc;
    private String vendor;
    private float amount;

    public Transaction(String date, String time, String desc, String vendor, float amount) {
        this.date = date;
        this.time = time;
        this.desc = desc;
        this.vendor = vendor;
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getDesc() {
        return desc;
    }

    public String getVendor() {
        return vendor;
    }

    public float getAmount() {
        return amount;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return String.format("%-10s | %-10s | %-40s | %-15s | $%5.2f", getDate(), String.format(String.valueOf(dateTimeFormatter)), getDesc(), getVendor(), getAmount());
    }

//    @Override
//     String toString() {
//        DecimalFormat df = new DecimalFormat("0.00");
//        String amountDF = df.format(getAmount());
//        return
//                " Date: " + getDate() + " | " +
//                        "Time: " + getTime() + " | " +
//                        "Description: " + getDesc() + " | " +
//                        "Vendor: " + getVendor() + " | " +
//                        "Amount: $" + amountDF;
//    }
}