package logics;

import entities.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.LinkedList;

public abstract class DAO {



    public abstract boolean checkClientExistence(String firstName, String lastName);
    public abstract boolean checkAdmin(String login, String password);
    public abstract Client getClientData(String firstName, String lastName);
    public abstract ArrayList<CreditCard> getClientCards(int clientId);
    public abstract BankAccount getAccount(int cardNumber);
    public abstract void balanceOperation(int cardNumber, double sum, int receiverAccount);
    public abstract void changeBlockStatus(int accountId, boolean status);
    public abstract LinkedList<CardRequest> getRequests();
    public abstract LinkedList<Transaction> getHistory(int cardNumber);
    public abstract void addCardRequest(int clientId, TypeCard typeCard);
    public abstract void approveRequest(int requestId);
    public abstract void rejectRequest(int requestId);
}
