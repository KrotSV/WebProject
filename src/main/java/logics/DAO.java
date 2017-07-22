package logics;

import entities.BankAccount;
import entities.Client;

import java.util.GregorianCalendar;

public abstract class DAO {
    public abstract boolean checkExistence(String firstName, String lastName, GregorianCalendar birthday);
    public abstract boolean checkAdmin(String ligin, String password);
    public abstract Client getClientData(String firstName, String lastName, GregorianCalendar birthday);
    public abstract BankAccount getAccount(int cardNumber);
    public abstract boolean balanceOperation(int cardNumber, double sum);
    public abstract boolean blockAccount(int cardNumber);
    public abstract boolean changeBlockStatus(int accountId);
}
