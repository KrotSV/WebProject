package resources.test;

import entities.Admin;
import entities.BankAccount;
import entities.Client;
import entities.CreditCard;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class DatabaseEmulator {
    private ArrayList<Admin> admins = new ArrayList<Admin>();
    private ArrayList<Client> clients = new ArrayList<Client>();
    private ArrayList<CreditCard> cards = new ArrayList<CreditCard>();
    private ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();

    public DatabaseEmulator() {
        BankAccount acc1 = new BankAccount(101, 5000, false, 4231);
        BankAccount acc2 = new BankAccount(102, 20000, false, 4321);
        BankAccount acc3 = new BankAccount(101, 1000, false, 1234);
        BankAccount acc4 = new BankAccount(202, 25000, false);
        accounts.add(acc1);
        accounts.add(acc2);
        accounts.add(acc3);
        accounts.add(acc4);


        admins.add(new Admin("qwerty", "12345"));
        admins.add(new Admin("asdfg", "54321"));


        CreditCard c1 = new CreditCard(4231, "Sergey Krotov", 3, 2018, 101);
        CreditCard c2 = new CreditCard(4321, "Sergey Krotov", 2, 2019, 102);
        CreditCard c3 = new CreditCard(1234, "Ivan Ivanov", 1, 2018, 201);

        ArrayList<CreditCard> skCards = new ArrayList<CreditCard>();
        ArrayList<CreditCard> iiCards = new ArrayList<CreditCard>();
        skCards.add(c1);
        skCards.add(c2);
        iiCards.add(c3);
        cards.addAll(skCards);
        cards.addAll(iiCards);


        GregorianCalendar bd1 = new GregorianCalendar(1990, 7, 21);
        GregorianCalendar bd2 = new GregorianCalendar(1950, 5, 5);

        Client cl1 = new Client(1, "Sergey", "Krotov", bd1, skCards);
        Client cl2 = new Client(2, "Ivan", "Ivanov", bd2, iiCards);
        clients.add(cl1);
        clients.add(cl2);
    }

    public void setAccounts(ArrayList<BankAccount> accounts) {
        this.accounts = accounts;
    }

    public ArrayList<Admin> getAdmins() {
        return admins;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public ArrayList<CreditCard> getCards() {
        return cards;
    }

    public ArrayList<BankAccount> getAccounts() {
        return accounts;
    }
}

