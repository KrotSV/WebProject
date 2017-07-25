package logics;

import entities.*;
import resources.test.DatabaseEmulator;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;

public class DAOJava extends DAO {

    private DatabaseEmulator database = new DatabaseEmulator();

    public boolean checkClientExistence(String firstName, String lastName) {
        ArrayList<Client> clients = database.getClients();
        Iterator<Client> iterator = clients.iterator();
        while (iterator.hasNext()){
            if(!iterator.next().getFirstName().equals(firstName)){
                iterator.remove();
            }
        }
        while (iterator.hasNext()){
            if(!iterator.next().getLastName().equals(lastName)){
                iterator.remove();
            }
        }
        return !clients.isEmpty();
    }

    public boolean checkAdmin(String login, String password) {
        ArrayList<Admin> admins = database.getAdmins();
        Iterator<Admin> iterator = admins.iterator();
        while (iterator.hasNext()) {
            if (!iterator.next().getLogin().equals(login)) {
                iterator.remove();
            }
        }
        while (iterator.hasNext()) {
            if (!iterator.next().getPassword().equals(password)) {
                iterator.remove();
            }
        }
        return !admins.isEmpty();
    }

    public Client getClientData(String firstName, String lastName) {
        Client client = null;
        for (Client cl:database.getClients()) {
            if(cl.getLastName().equals(lastName)){
                client = cl;
                break;
            }
        }
        return client;
    }

    public Client getClientData(int clientId) {
        Client client = null;
        for (Client cl:database.getClients()) {
            if(cl.getClientId() == clientId){
                client = cl;
                break;
            }
        }
        return client;
    }

    public ArrayList<CreditCard> getClientCards(int clientId) {
        ArrayList<CreditCard> cards = database.getCards();
        Iterator<CreditCard> iterator = cards.iterator();
        while (iterator.hasNext()){
            if(iterator.next().getClientId() != clientId)
            iterator.remove();
        }
        return cards;
    }

    public BankAccount getAccount(int cardNumber) {
        BankAccount bankAccount = null;
        for (BankAccount ba:database.getAccounts()) {
            if(ba.getCardNumber() == cardNumber){
                bankAccount = ba;
                break;
            }
        }
        return bankAccount;

    }

    public boolean balanceOperation(int cardNumber, double sum) {
        BankAccount account = null;
        int accId = 0;
        for (CreditCard cc:database.getCards()) {
            if(cc.getCardNumber() == cardNumber) {
                accId = cc.getAccountId();
                break;
            }
        }
        for (BankAccount ba:database.getAccounts()) {
            if(ba.getAccountId() == accId){
                account = ba;
                break;
            }
        }
        assert account != null;
        account.setBalance(account.getBalance() + sum);
        return true;
    }



    public boolean changeBlockStatus(int accountId, boolean status) {
        for (BankAccount ba:database.getAccounts()) {
            if(ba.getAccountId() == accountId){
                ba.setStatus(status);
                break;
            }
        }
        return true;
    }

    public LinkedList<CardRequest> getRequests() {

        return database.getRequests();
    }

    public LinkedList<Transaction> getHistory(int cardNumber) {
        int id = getAccount(cardNumber).getAccountId();
        LinkedList<Transaction> transactions = database.getHistory();
        Iterator<Transaction> iterator = transactions.iterator();
        System.out.println("start size: " + transactions.size());
        while (iterator.hasNext()){
            if(iterator.next().getAccountId() != id) {
                iterator.remove();
            }
        }

        System.out.println("end size: " + transactions.size());
        return transactions;
    }

    public boolean addTransaction(int cardNumber, double sum) {
        LinkedList<Transaction> history = database.getHistory();
        history.add(new Transaction(getAccount(cardNumber).getAccountId(), Calendar.getInstance(), sum));
        database.setHistory(history);
        return true;
    }

    public boolean addCardRequest(int clientId, TypeCard typeCard) {
        LinkedList<CardRequest> requests = database.getRequests();
        requests.add(new CardRequest(Calendar.getInstance(), clientId, typeCard, false));
        database.setRequests(requests);
        return true;
    }
}
