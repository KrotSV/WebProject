package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Client implements Serializable{
    private int clientId;
    private String firstName;
    private String lastName;
    private GregorianCalendar birthday;
    private ArrayList<CreditCard> cards;

    public Client(){}

    public Client(int clientId, String firstName, String lastName, GregorianCalendar birthday, ArrayList<CreditCard> cards) {
        this.clientId = clientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.cards = cards;
    }

    public GregorianCalendar getBirthday() {
        return birthday;
    }

    public ArrayList<CreditCard> getCards() {
        return cards;
    }

    public int getClientId() {
        return clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


}
