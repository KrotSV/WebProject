package logics;

import entities.*;

import java.util.ArrayList;
import java.util.LinkedList;

public abstract class DAO {
    public abstract boolean checkClientExistence(String firstName, String lastName);
    public abstract boolean checkAdmin(String login, String password);
    public abstract Client getClientData(String firstName, String lastName);
    public abstract Client getClientData(int clientId);
    public abstract ArrayList<CreditCard> getClientCards(int clientId);
    public abstract BankAccount getAccount(int cardNumber);
    public abstract boolean balanceOperation(int cardNumber, double sum);
    public abstract boolean changeBlockStatus(int accountId, boolean status);
    public abstract LinkedList<CardRequest> getRequests();
    public abstract LinkedList<Transaction> getHistory(int cardNumber);
    public abstract boolean addTransaction(int cardNumber, double sum);
    public abstract boolean addCardRequest(int clientId, TypeCard typeCard);
}
