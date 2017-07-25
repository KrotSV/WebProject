package entities;

import java.io.Serializable;
import java.util.Calendar;

public class Transaction implements Serializable{
    private int CardNumber;
    private Calendar date;
    private double sum;

    public Transaction(){}

    public Transaction(int cardNumber, Calendar date, double sum) {
        CardNumber = cardNumber;
        this.date = date;
        this.sum = sum;
    }

    public int getCardNumber() {
        return CardNumber;
    }

    public void setCardNumber(int cardNumber) {
        CardNumber = cardNumber;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }
}

