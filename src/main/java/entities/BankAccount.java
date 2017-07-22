package entities;

public class BankAccount {
    private int accountId;
    private double balance;
    private boolean isBlocked;

    public BankAccount(int accountId, double balance, boolean isBlocked) {
        this.accountId = accountId;
        this.balance = balance;
        this.isBlocked = isBlocked;
    }

    public int getAccountId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }
}
