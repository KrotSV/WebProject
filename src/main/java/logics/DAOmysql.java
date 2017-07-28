package logics;

import entities.*;


import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class DAOmysql extends DAO {

    public int testDB() {
        int out = 0;
        try(Connection conn = this.getDataSource().getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM clients WHERE clientId=? AND firstName=?");
//            ps.setInt(1, 1);
            ps.setInt(1, 2);
            ps.setString(2, "Ivan");

            ResultSet resultSet = ps.executeQuery();
//            out = resultSet.getString("login");
            System.out.println("print result");
            out = resultSet.getRow();
            ResultSetMetaData meta = resultSet.getMetaData();
            System.out.println("Strings: " + meta.getColumnCount());
            System.out.println("2nd column: " + meta.getColumnName(2));
            if (!resultSet.isBeforeFirst()) {
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
        PreparedStatement ps = null;
        boolean check = false;
        try (Connection conn = this.getDataSource().getConnection()) {

            ps = conn.prepareStatement("SELECT * FROM clients WHERE firstName=? AND lastName=?");
            ps.setString(1, firstName);
            ps.setString(2, lastName);

            ResultSet result = ps.executeQuery();
            check = result.isBeforeFirst();
            System.out.println("CHECK IS!!)@()@*!#_)" + check);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(ps != null)
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return check;
    }


    @Override
    public boolean checkAdmin(String login, String password) {

        PreparedStatement ps = null;
        boolean check = false;
        try (Connection conn = this.getDataSource().getConnection()) {
            ps = conn.prepareStatement("SELECT * FROM admins WHERE login=? AND password=?");
            ps.setString(1, login);
            ps.setString(2, password);
            ResultSet result = ps.executeQuery();
            System.out.println(result.getRow());
            check = result.isBeforeFirst();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(ps != null)
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return check;
    }

    @Override
    public Client getClientData(String firstName, String lastName) {
        PreparedStatement ps = null;
        Client client = new Client();
        try (Connection conn = this.getDataSource().getConnection()) {

            ps = conn.prepareStatement("SELECT * FROM clients WHERE firstName=? AND lastName=?");
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ResultSet result = ps.executeQuery();
            result.next();
                client.setClientId(result.getInt("clientId"));
                client.setFirstName(firstName);
                client.setLastName(lastName);
                client.setBirthday(result.getDate("birthday"));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(ps != null)
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return client;
    }

    @Override
    public ArrayList<CreditCard> getClientCards(int clientId) {
        ArrayList<CreditCard> cards = new ArrayList<>();
        PreparedStatement ps = null;
        try(Connection conn = this.getDataSource().getConnection()) {
            ps = conn.prepareStatement("SELECT * FROM creditcards WHERE clientId = ?");
            ps.setInt(1, clientId);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                CreditCard card = new CreditCard();
                card.setCardNumber(result.getInt("cardNumber"));
                card.setValidity(result.getDate("validity"));
                card.setAccountId(result.getInt("accountId"));
                card.setClientId(clientId);
                card.setTypeCard(TypeCard.valueOf(result.getString("typeCard")));
                cards.add(card);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cards;
    }

    @Override
    public BankAccount getAccount(int cardNumber) {
//        Connection connection = DBPool.getConnection();
//        BankAccount account = new BankAccount();
//        try {
//            PreparedStatement ps = connection.prepareStatement("SELECT * FROM bankaccounts WHERE cardNumber = ?");
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
//        return account;
        return  null;
    }

    @Override
    public void balanceOperation(int cardNumber, double sum) {
//        Connection connection = DBPool.getConnection();
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
    public void changeBlockStatus(int Id, boolean status) {

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
