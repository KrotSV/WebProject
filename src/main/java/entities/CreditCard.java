package entities;

import java.io.Serializable;
import java.util.Calendar;

public class CreditCard implements Serializable{
    private int cardNumber;
    private String owner;
    private Calendar validity;
    private int accountId;
    private int clientId;
    private TypeCard typeCard;


    private double limit;

    public CreditCard(){}

    public CreditCard(int cardNumber, String owner, int clientId, Calendar validity, TypeCard typeCard, double limit, int accountId) {
        this.cardNumber = cardNumber;
        this.owner = owner;
        this.clientId = clientId;
        this.validity = validity;
        this.typeCard = typeCard;
        this.limit = limit;
        this.accountId = accountId;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public String getOwner() {
        return owner;
    }

    public Calendar getValidity() {
        return validity;
    }

    public TypeCard getTypeCard() {
        return typeCard;
    }

    public int getAccountId() {
        return accountId;
    }

    public double getLimit() {
        return limit;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setValidity(Calendar validity) {
        this.validity = validity;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public void setTypeCard(TypeCard typeCard) {
        this.typeCard = typeCard;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
}
