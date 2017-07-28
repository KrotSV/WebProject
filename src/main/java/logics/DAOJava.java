package logics;

import entities.*;
import resources.test.DatabaseEmulator;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;

public class DAOJava  {

//    private DatabaseEmulator database = new DatabaseEmulator();
//
//    @Override
//    public String testDB(Connection connection) {
//        return null;
//    }
//
//    public boolean checkExistence(String firstName, String lastName) {
//        ArrayList<Client> clients = database.getClients();
//        Iterator<Client> iterator = clients.iterator();
//        while (iterator.hasNext()){
//            if(!iterator.next().getFirstName().equals(firstName)){
//                iterator.remove();
//            }
//        }
//        while (iterator.hasNext()){
//            if(!iterator.next().getLastName().equals(lastName)){
//                iterator.remove();
//            }
//        }
//        return !clients.isEmpty();
//    }
//
//    public boolean checkAdmin(String login, String password) {
//        ArrayList<Admin> admins = database.getAdmins();
//        Iterator<Admin> iterator = admins.iterator();
//        while (iterator.hasNext()) {
//            if (!iterator.next().getLogin().equals(login)) {
//                iterator.remove();
//            }
//        }
//        while (iterator.hasNext()) {
//            if (!iterator.next().getPassword().equals(password)) {
//                iterator.remove();
//            }
//        }
//        return !admins.isEmpty();
//    }
//
//    public Client getData(String firstName, String lastName) {
//        Client client = null;
//        for (Client cl:database.getClients()) {
//            if(cl.getLastName().equals(lastName)){
//                client = cl;
//                break;
//            }
//        }
//        return client;
//    }
//
//    public Client getData(int clientId) {
//        Client client = null;
//        for (Client cl:database.getClients()) {
//            if(cl.getClientId() == clientId){
//                client = cl;
//                break;
//            }
//        }
//        return client;
//    }
//
//    public ArrayList<CreditCard> getEntitiesList(int clientId) {
//        ArrayList<CreditCard> cards = database.getCards();
//        Iterator<CreditCard> iterator = cards.iterator();
//        while (iterator.hasNext()){
//            if(iterator.next().getClientId() != clientId)
//            iterator.remove();
//        }
//        return cards;
//    }
//
//    public BankAccount getAccount(int cardNumber) {
//        BankAccount bankAccount = null;
//        for (BankAccount ba:database.getAccounts()) {
//            if(ba.getCardNumber() == cardNumber){
//                bankAccount = ba;
//                break;
//            }
//        }
//        return bankAccount;
//
//    }
//
//    public void balanceOperation(int cardNumber, double sum) {
//        LinkedList<BankAccount> accounts = database.getAccounts();
//        BankAccount temp = null;
//        Iterator<BankAccount> iterator = accounts.iterator();
//        while (iterator.hasNext()){
//            temp = iterator.next();
//            if(temp.getCardNumber() == cardNumber){
//                iterator.remove();
//                break;
//            }
//        }
//        temp.setBalance(temp.getBalance() + sum);
//        accounts.add(temp);
//        database.setAccounts(accounts);
//    }
//
//
//
//    public void changeStatus(int accountId, boolean status) {
//        for (BankAccount ba:database.getAccounts()) {
//            if(ba.getAccountId() == accountId){
//                ba.setStatus(status);
//                break;
//            }
//        }
//    }
//
//    public LinkedList<CardRequest> getRequests() {
//
//        return database.getRequests();
//    }
//
//    public LinkedList<Transaction> getHistory(int cardNumber) {
//        int id = getAccount(cardNumber).getAccountId();
//        LinkedList<Transaction> transactions = database.getHistory();
//        Iterator<Transaction> iterator = transactions.iterator();
//        System.out.println("start size: " + transactions.size());
//        while (iterator.hasNext()){
//            if(iterator.next().getAccountId() != id) {
//                iterator.remove();
//            }
//        }
//
//        System.out.println("end size: " + transactions.size());
//        return transactions;
//    }
//
//    public void addTransaction(int cardNumber, double sum) {
//        LinkedList<Transaction> history = database.getHistory();
//        history.add(new Transaction(history.size() + 1, getAccount(cardNumber).getAccountId(), Calendar.getInstance(), sum));
//        database.setHistory(history);
//    }
//
//    public void addCardRequest(int clientId, TypeCard typeCard) {
//        LinkedList<CardRequest> requests = database.getRequests();
//        requests.add(new CardRequest(requests.size() + 1, Calendar.getInstance(), clientId, typeCard, false));
//        database.setRequests(requests);
//    }
//
//    public void approveRequest(int requestId) {
//        for (CardRequest ca:database.getRequests()) {
//            if(ca.getRequestId() == requestId){
//                ca.setApproval(true);
//                break;
//            }
//        }
//    }
//
//    public void rejectRequest(int requestId) {
//        for (CardRequest ca:database.getRequests()) {
//            if(ca.getRequestId() == requestId){
//                ca.setApproval(false);
//                break;
//            }
//        }
//    }
}
