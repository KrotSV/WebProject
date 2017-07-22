package logics;

import entities.BankAccount;
import entities.Client;
import resources.test.DatabaseEmulator;

import java.util.GregorianCalendar;

public class DAOJava extends DAO {

    DatabaseEmulator database = new DatabaseEmulator();

    public boolean checkExistence(String firstName, String lastName, GregorianCalendar birthday) {
        return false;
    }

    public Client getClientData(String firstName, String lastName, GregorianCalendar birthday) {
        return null;
    }

    public BankAccount getAccount(int cardNumber) {
        return null;
    }

    public boolean balanceOperation(int cardNumber, double sum) {
        return false;
    }

    public boolean blockAkkount(int cardNumber) {
        return false;
    }

    public boolean changeBlockStatus(int accountId) {
        return false;
    }
}
