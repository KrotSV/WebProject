package logics;

import entities.Admin;
import entities.BankAccount;
import entities.Client;
import entities.CreditCard;
import resources.test.DatabaseEmulator;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;

public class DAOJava extends DAO {

    DatabaseEmulator database = new DatabaseEmulator();

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

    public boolean checkAdmin(String ligin, String password) {
        ArrayList<Admin> admins = database.getAdmins();
        Iterator<Admin> iterator = admins.iterator();
        while (iterator.hasNext()) {
            if (!iterator.next().getLogin().equals(ligin)) {
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

    public BankAccount getAccount(int cardNumber) {
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
        return account;

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

    public boolean blockAccount(int cardNumber) {
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
        account.setStatus(true);
        return true;
    }

    public boolean changeBlockStatus(int accountId) {
        for (BankAccount ba:database.getAccounts()) {
            if(ba.getAccountId() == accountId){
                ba.setStatus(!ba.getStatus());
                break;
            }
        }
        return true;
    }
}
