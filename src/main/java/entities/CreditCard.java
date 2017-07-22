package entities;

public class CreditCard {
    private int cardNumber;
    private String owner;
    private int endMonth;
    private int endYear;
    private BankAccount account;

    public CreditCard(int cardNumber, String owner, int endMonth, int endYear, BankAccount account) {
        this.cardNumber = cardNumber;
        this.owner = owner;
        this.endMonth = endMonth;
        this.endYear = endYear;
        this.account = account;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public String getOwner() {
        return owner;
    }

    public int getEndMonth() {
        return endMonth;
    }

    public int getEndYear() {
        return endYear;
    }

    public BankAccount getAccount() {
        return account;
    }
}
