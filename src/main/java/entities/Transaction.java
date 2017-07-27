package entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class Transaction implements Serializable{
    private int transactionId;
    private int accountId;
    private Date date;
    private double sum;

    public Transaction(){}

    public Transaction(int transactionId, int accountId, Date date, double sum) {
        this.transactionId = transactionId;
        this.accountId = accountId;
        this.date = date;
        this.sum = sum;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        accountId = accountId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }
}

