package resources.test;

import entities.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;

public class DatabaseEmulator {
    private ArrayList<Admin> admins = new ArrayList<Admin>();
    private ArrayList<Client> clients = new ArrayList<Client>();
    private ArrayList<CreditCard> cards = new ArrayList<CreditCard>();
    private ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
    private LinkedList<CardRequest> requests = new LinkedList<CardRequest>();
    private LinkedList<Transaction> history = new LinkedList<Transaction>();


    public DatabaseEmulator() {
        GregorianCalendar bd1 = new GregorianCalendar(1990, 7, 21);
        GregorianCalendar bd2 = new GregorianCalendar(1950, 5, 5);
        GregorianCalendar val1 = new GregorianCalendar(2018, 5, 7);
        GregorianCalendar val2 = new GregorianCalendar(2014, 2, 8);
        GregorianCalendar val3 = new GregorianCalendar(2018, 4, 3);
        GregorianCalendar val4 = new GregorianCalendar(2018, 5, 7);
        GregorianCalendar tr1 = new GregorianCalendar(2017, 6, 5, 12, 5);
        GregorianCalendar tr2 = new GregorianCalendar(2017, 6, 5, 12, 5);
        GregorianCalendar tr3 = new GregorianCalendar(2017, 6, 5, 12, 5);
        GregorianCalendar tr4 = new GregorianCalendar(2017, 6, 5, 12, 5);
        GregorianCalendar tr5 = new GregorianCalendar(2017, 6, 5, 13, 50);
        GregorianCalendar tr6 = new GregorianCalendar(2017, 6, 5, 14, 25);

        Transaction transaction1 = new Transaction(4231, tr1, 5000);
        Transaction transaction2 = new Transaction(4321, tr4, 30000);
        Transaction transaction3 = new Transaction(4321, tr5, -20000);
        Transaction transaction4 = new Transaction(4321, tr6, 10000);
        Transaction transaction5 = new Transaction(4123, tr2, 25000);
        Transaction transaction6 = new Transaction(1234, tr3, 1000);

        ArrayList<Transaction> hist1 = new ArrayList<Transaction>();
        ArrayList<Transaction> hist2 = new ArrayList<Transaction>();
        ArrayList<Transaction> hist3 = new ArrayList<Transaction>();
        ArrayList<Transaction> hist4 = new ArrayList<Transaction>();
        hist1.add(transaction1);
        hist2.add(transaction2);
        hist2.add(transaction3);
        hist2.add(transaction4);
        hist3.add(transaction5);
        hist4.add(transaction6);
        history.addAll(hist1);
        history.addAll(hist2);
        history.addAll(hist3);
        history.addAll(hist4);


        BankAccount acc1 = new BankAccount(101, 5000, false, 4231, TypeCard.CREDIT, -50000);
        BankAccount acc2 = new BankAccount(102, 20000, false, 4321, TypeCard.DEBET, 0);
        BankAccount acc4 = new BankAccount(104, 1000, false, 1234, TypeCard.CREDIT, -200000);
        BankAccount acc3 = new BankAccount(103, 25000, false, 4123, TypeCard.DEBET, 0);
        accounts.add(acc1);
        accounts.add(acc2);
        accounts.add(acc3);
        accounts.add(acc4);


        admins.add(new Admin("qwerty", "12345"));
        admins.add(new Admin("asdfg", "54321"));


        CreditCard c1 = new CreditCard(4231, "Sergey Krotov", 1, val1, TypeCard.CREDIT, -50000, 101);
        CreditCard c4 = new CreditCard(4321, "Sergey Krotov", 1,val2, TypeCard.DEBET, 0, 102);
        CreditCard c2 = new CreditCard(4123, "Sergey Krotov", 1,val3, TypeCard.DEBET, 0, 103);
        CreditCard c3 = new CreditCard(1234, "Ivan Ivanov", 2,val4, TypeCard.CREDIT, -200000, 204);

        ArrayList<CreditCard> skCards = new ArrayList<CreditCard>();
        ArrayList<CreditCard> iiCards = new ArrayList<CreditCard>();
        skCards.add(c1);
        skCards.add(c2);
        skCards.add(c4);
        iiCards.add(c3);
        cards.addAll(skCards);
        cards.addAll(iiCards);


        Client cl1 = new Client(1, "Sergey", "Krotov", bd1);
        Client cl2 = new Client(2, "Ivan", "Ivanov", bd2);
        clients.add(cl1);
        clients.add(cl2);

        CardRequest request1 = new CardRequest(Calendar.getInstance(), 1, TypeCard.CREDIT, false);
        CardRequest request2 = new CardRequest(Calendar.getInstance(), 2, TypeCard.DEBET, true);
        requests.add(request1);
        requests.add(request2);

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

    public LinkedList<CardRequest> getRequests() {
        return requests;
    }

    public LinkedList<Transaction> getHistory() {
        return history;
    }

    public void setRequests(LinkedList<CardRequest> requests) {
        this.requests = requests;
    }

    public void setHistory(LinkedList<Transaction> history) {
        this.history = history;
    }
}

