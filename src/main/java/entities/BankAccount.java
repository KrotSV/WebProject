package entities;

import java.io.Serializable;

public class BankAccount implements Serializable{
    private int accountId;
    private double balance;
    private boolean status;

    public BankAccount(){}

    public BankAccount(int accountId, double balance, boolean isBlocked) {
        this.accountId = accountId;
        this.balance = balance;
        this.status = isBlocked;
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
}
