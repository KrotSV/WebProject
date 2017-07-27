package logics;

import entities.*;


import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class DAOmysql extends DAO{


    public String testDB(Connection connection){
        String out = null;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM clients");
//            ps.setInt(1, 1);
            ResultSet resultSet = ps.executeQuery();
//            out = resultSet.getString("login");
            System.out.println("print result");
            while (resultSet.next()) {
                System.out.println("Номер в выборке #" + resultSet.getRow()
                        + "\t Номер в базе #" + resultSet.getInt("clientId")
                        + "\t" + resultSet.getString("firstName"));
            }
//            Statement statement = connection.createStatement();
//            statement.executeQuery()
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return out;
    }


    @Override
    public boolean checkClientExistence(String firstName, String lastName) {
        return false;
    }

    @Override
    public boolean checkAdmin(String login, String password) {
        return false;
    }

    @Override
    public Client getClientData(String firstName, String lastName) {
        return null;
    }

    @Override
    public ArrayList<CreditCard> getClientCards(int clientId) {
        return null;
    }

    @Override
    public BankAccount getAccount(int cardNumber) {
        return null;
    }

    @Override
    public void balanceOperation(int cardNumber, double sum) {

    }

    @Override
    public void changeBlockStatus(int accountId, boolean status) {

    }

    @Override
    public LinkedList<CardRequest> getRequests() {
        return null;
    }

    @Override
    public LinkedList<Transaction> getHistory(int cardNumber) {
        return null;
    }

    @Override
    public void addTransaction(int cardNumber, double sum) {

    }

    @Override
    public void addCardRequest(int clientId, TypeCard typeCard) {

    }

    @Override
    public void approveRequest(int requestId) {

    }

    @Override
    public void rejectRequest(int requestId) {

    }
}
