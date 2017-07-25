package logics;

import entities.BankAccount;
import entities.Client;
import entities.CardRequest;
import entities.Transaction;

import java.util.ArrayList;

public abstract class DAO {
    public abstract boolean checkClientExistence(String firstName, String lastName);
    public abstract boolean checkAdmin(String ligin, String password);
    public abstract Client getClientData(String firstName, String lastName);
    public abstract Client getClientData(int clientId);
    public abstract BankAccount getAccount(int cardNumber);
    public abstract boolean balanceOperation(int cardNumber, double sum);
    public abstract boolean blockAccount(int cardNumber);
    public abstract boolean changeBlockStatus(int accountId);
    public abstract ArrayList<CardRequest> getRequests();
    public abstract ArrayList<Transaction> getHistory();
}
