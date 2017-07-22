package entities;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Client {
    private int userId;
    private String firstName;
    private String lastName;
    private GregorianCalendar birthday;
    private ArrayList<CreditCard> cards;

    public Client(int userId, String firstName, String lastName, GregorianCalendar birthday, ArrayList<CreditCard> cards) {
        this.userId = userId;
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

    public int getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


}
