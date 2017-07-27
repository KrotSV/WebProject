package logics;

import entities.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.LinkedList;

public abstract class DAO {
    public abstract String testDB(Connection connection);
    public abstract boolean checkClientExistence(String firstName, String lastName);
    public abstract boolean checkAdmin(String login, String password);
    public abstract Client getClientData(String firstName, String lastName);
//    public abstract Client getClientData(int clientId);
    public abstract ArrayList<CreditCard> getClientCards(int clientId);
    public abstract BankAccount getAccount(int cardNumber);
    public abstract void balanceOperation(int cardNumber, double sum);
    public abstract void changeBlockStatus(int accountId, boolean status);
    public abstract LinkedList<CardRequest> getRequests();
    public abstract LinkedList<Transaction> getHistory(int cardNumber);
    public abstract void addTransaction(int cardNumber, double sum);
    public abstract void addCardRequest(int clientId, TypeCard typeCard);
    public abstract void approveRequest(int requestId);
    public abstract void rejectRequest(int requestId);
}
