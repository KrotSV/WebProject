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
            if (!resultSet.isBeforeFirst() ) {
                System.out.println("No data");
            }
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
        Connection connection = DBconnect.getConnection();
        boolean check = false;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM clients WHERE clients.firstName= ? & clients.lastName= ?");
            ps.setString(1, firstName);
            ps.setString(2, lastName);

            ResultSet result = ps.executeQuery();
            check = result.next();
            if (!result.isBeforeFirst() ) {
                System.out.println("No data");
            }
            while (result.next()) {
                System.out.println("Номер в выборке #" + result.getRow()
                        + "\t Номер в базе #" + result.getInt("clientId")
                        + "\t" + result.getString("firstName"));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public boolean checkAdmin(String login, String password) {
        Connection connection = DBconnect.getConnection();
        boolean check = false;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM admins WHERE login = ? & admins.password = ?");
            ps.setString(1, login);
            ps.setString(2, password);

            ResultSet result = ps.executeQuery();
            check = !result.wasNull();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public Client getClientData(String firstName, String lastName) {
        Connection connection = DBconnect.getConnection();
        Client client = new Client();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM clients WHERE firstName = ? & clients.lastName = ?");
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ResultSet result = ps.executeQuery();
            client.setFirstName(result.getString("firstName"));
            client.setLastName(result.getString("lastName"));
            client.setBirthday(result.getDate("birthday"));
            client.setClientId(result.getInt("clientId"));
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;

    }

    @Override
    public ArrayList<CreditCard> getClientCards(int clientId) {
        Connection connection = DBconnect.getConnection();
        ArrayList<CreditCard> cards = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM creditcards WHERE clientId = ?");
            ps.setInt(1, clientId);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                CreditCard card = new CreditCard();
                card.setAccountId(result.getInt("accountId"));
                card.setCardNumber(result.getInt("cardNumber"));
                card.setClientId(clientId);
                card.setLimit(result.getDouble("limitSum"));
                card.setTypeCard(TypeCard.valueOf(result.getString("typeCard")));
                card.setOwner(result.getString("owner"));
                card.setValidity(result.getDate("validity"));
                cards.add(card);
            }
            connection.close();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return cards;
    }

        @Override
    public BankAccount getAccount(int cardNumber) {
            Connection connection = DBconnect.getConnection();
            BankAccount account = new BankAccount();
            try {
                PreparedStatement ps = connection.prepareStatement("SELECT * FROM bankaccounts WHERE cardNumber = ?");
                ps.setInt(1, cardNumber);
                ResultSet result = ps.executeQuery();
                account.setAccountId(result.getInt("accountId"));
                account.setCardNumber(cardNumber);
                account.setBalance(result.getDouble("balance"));
                account.setLimit(result.getDouble("limitSum"));
                account.setTypeCard(TypeCard.valueOf(result.getString("typeCard")));
                account.setStatus(result.getBoolean("status"));
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return account;
    }

    @Override
    public void balanceOperation(int cardNumber, double sum) {
//        Connection connection = DBconnect.getConnection();
//        try {
//            PreparedStatement ps = connection.prepareStatement("UPDATE bankaccounts SET balance = ? WHERE cardNumber = ?");
//            ps.setDouble(1, cardNumber);
//            ps.setInt(1, cardNumber);
//            ResultSet result = ps.executeQuery();
//            account.setAccountId(result.getInt("accountId"));
//            account.setCardNumber(cardNumber);
//            account.setBalance(result.getDouble("balance"));
//            account.setLimit(result.getDouble("limitSum"));
//            account.setTypeCard(TypeCard.valueOf(result.getString("typeCard")));
//            account.setStatus(result.getBoolean("status"));
//            connection.close();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
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
