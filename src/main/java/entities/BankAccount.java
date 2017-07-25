package entities;

import com.sun.xml.internal.stream.StaxErrorReporter;

import java.io.Serializable;
import java.util.ArrayList;

public class BankAccount implements Serializable{
    private int accountId;
    private double balance;
    private boolean status;
    private int cardNumber;


    public BankAccount(){}

    public BankAccount(int accountId, double balance, boolean isBlocked, int cardNumber) {
        this.accountId = accountId;
        this.balance = balance;
        this.status = isBlocked;
        this.cardNumber = cardNumber;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public int getAccountId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }

    public boolean getStatus() {
        return status;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setStatus(boolean blocked) {
        status = blocked;
    }

    public boolean isStatus() {
        return status;
    }


    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

}
