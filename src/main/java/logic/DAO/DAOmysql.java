package logic.DAO;

import entities.*;
import org.apache.log4j.Logger;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class DAOmysql extends DAO {
    private DataSource dataSource;
    private static Logger logger = Logger.getLogger(DAOmysql.class);

    public DAOmysql(){
        Context initContext;
        try {
            initContext = new InitialContext();
            Context envContext  = (Context)initContext.lookup("java:/comp/env");
            this.dataSource = (DataSource)envContext.lookup("jdbc/PaymentSystem");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    private DataSource getDataSource(){
        return this.dataSource;
    }

//    public int testDB() {
//        int out = 0;
//        try (Connection conn = this.getDataSource().getConnection()) {
//            PreparedStatement ps = conn.prepareStatement("SELECT * FROM clients WHERE clientId=? AND firstName=?");
//            ps.setInt(1, 2);
//            ps.setString(2, "Ivan");
//
//            ResultSet resultSet = ps.executeQuery();
//            System.out.println("print result");
//            out = resultSet.getRow();
//            ResultSetMetaData meta = resultSet.getMetaData();
//            System.out.println("Strings: " + meta.getColumnCount());
//            System.out.println("2nd column: " + meta.getColumnName(2));
//            if (!resultSet.isBeforeFirst()) {
//                System.out.println("No data");
//            }
//            while (resultSet.next()) {
//                System.out.println("Номер в выборке #" + resultSet.getRow()
//                        + "\t Номер в базе #" + resultSet.getInt("clientId")
//                        + "\t" + resultSet.getString("firstName"));
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return out;
//    }


    @Override
    public boolean checkClientExistence(String firstName, String lastName) {
        boolean check = false;
        try (Connection conn = this.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM clients WHERE firstName=? AND lastName=?")) {

            ps.setString(1, firstName);
            ps.setString(2, lastName);

            ResultSet result = ps.executeQuery();
            check = result.isBeforeFirst();
        } catch (SQLException e) {
            logger.error("SQL error " + e);
        }
        return check;
    }


    @Override
    public boolean checkAdmin(String login, String password) {

        boolean check = false;
        try (Connection conn = this.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM admins WHERE login=? AND password=?")) {
            ps.setString(1, login);
            ps.setString(2, password);
            ResultSet result = ps.executeQuery();
            check = result.isBeforeFirst();

        } catch (SQLException e) {
            logger.error("SQL error " + e);
        }
        return check;
    }

    @Override
    public Client getClientData(String firstName, String lastName) {
        Client client = new Client();
        try (Connection conn = this.getDataSource().getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM clients WHERE firstName=? AND lastName=?")) {

            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ResultSet result = ps.executeQuery();
            result.next();
            client.setClientId(result.getInt("clientId"));
            client.setFirstName(firstName);
            client.setLastName(lastName);
            client.setBirthday(result.getDate("birthday"));

        } catch (SQLException e) {
            logger.error("SQL error " + e);
        }
        return client;
    }

    @Override
    public ArrayList<CreditCard> getClientCards(int clientId) {
        ArrayList<CreditCard> cards = new ArrayList<>();
        try (Connection conn = this.getDataSource().getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM creditcards WHERE clientId = ?")) {
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
            logger.error("SQL error " + e);
        }
        return cards;
    }

    @Override
    public BankAccount getAccount(int cardNumber) {
        BankAccount account = new BankAccount();
        PreparedStatement ps = null;
        try (Connection conn = this.getDataSource().getConnection()) {
            ps = conn.prepareStatement("SELECT * FROM creditcards WHERE cardNumber=?");
            ps.setInt(1, cardNumber);
            ResultSet resultCard = ps.executeQuery();
            resultCard.next();
            int accountId = resultCard.getInt("accountId");

            ps = conn.prepareStatement("SELECT * FROM bankaccounts WHERE accountId=?");
            ps.setInt(1, accountId);
            ResultSet result = ps.executeQuery();
            result.next();
            account.setAccountId(result.getInt("accountId"));
            account.setBalance(result.getDouble("balance"));
            account.setLimit(result.getDouble("limitSum"));
            account.setStatus(result.getBoolean("status"));

        } catch (SQLException e) {
            logger.error("SQL error " + e);
        } finally {
            try {
                if (ps != null)
                    ps.close();
            } catch (SQLException e) {
                logger.error("SQL error " + e);
            }
        }
        return account;
    }

    @Override
    public void balanceOperation(int cardNumber, double sum, int receiverAccount) {
        PreparedStatement ps = null;
        try (Connection conn = this.getDataSource().getConnection()) {
            ps = conn.prepareStatement("SELECT * FROM creditcards WHERE cardNumber=?");
            ps.setInt(1, cardNumber);
            ResultSet resultCard = ps.executeQuery();
            resultCard.next();

            int accountId = resultCard.getInt("accountId");

            ps = conn.prepareStatement("UPDATE bankaccounts SET balance=balance+? WHERE accountId = ?");
            ps.setDouble(1, sum);
            ps.setInt(2, accountId);
            ps.executeUpdate();

            ps = conn.prepareStatement("INSERT INTO transactions (accountId, date, sum, receiverAccount) VALUES (?, ?, ?, ?)");
            ps.setInt(1, accountId);
            ps.setDate(2, java.sql.Date.valueOf(java.time.LocalDate.now()));
            ps.setDouble(3, sum);
            ps.setInt(4, receiverAccount);
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.error("SQL error " + e);
        } finally {
            try {
                if (ps != null)
                    ps.close();
            } catch (SQLException e) {
                logger.error("SQL error " + e);
            }
        }
    }


    @Override
    public void changeBlockStatus(int cardNumber, boolean status) {
        PreparedStatement ps = null;
        try (Connection conn = this.getDataSource().getConnection()) {

            ps = conn.prepareStatement("SELECT * FROM creditcards WHERE cardNumber=?");
            ps.setInt(1, cardNumber);
            ResultSet resultCard = ps.executeQuery();
            resultCard.next();

            int accountId = resultCard.getInt("accountId");

            ps = conn.prepareStatement("UPDATE bankaccounts SET status = ? WHERE accountId = ?");
            ps.setBoolean(1, status);
            ps.setInt(2, accountId);
            ps.executeUpdate();
        } catch (
                SQLException e)

        {
            logger.error("SQL error " + e);
        } finally {
            try {
                if (ps != null)
                    ps.close();
            } catch (SQLException e) {
                logger.error("SQL error " + e);
            }
        }
    }


    @Override
    public LinkedList<CardRequest> getRequests() {
        LinkedList<CardRequest> requests = new LinkedList<>();
        try (Connection conn = this.getDataSource().getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM cardrequests")) {
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                CardRequest request = new CardRequest();
                request.setRequestId(result.getInt("requestId"));
                request.setDate(new java.util.Date(result.getTimestamp("date").getTime()));
                request.setClientId(result.getInt("clientId"));
                request.setTypeCard(TypeCard.valueOf(result.getString("typeCard")));
                request.setApproval(result.getBoolean("approval"));
                requests.add(request);
            }
        } catch (SQLException e) {
            logger.error("SQL error " + e);
        }
        return requests;
    }

    @Override
    public LinkedList<Transaction> getHistory(int cardNumber) {
        LinkedList<Transaction> transactions = new LinkedList<>();
        PreparedStatement ps = null;
        try (Connection conn = this.getDataSource().getConnection()) {
            ps = conn.prepareStatement("SELECT * FROM creditcards WHERE cardNumber=?");
            ps.setInt(1, cardNumber);
            ResultSet resultCard = ps.executeQuery();
            resultCard.next();

            int accountId = resultCard.getInt("accountId");

            ps = conn.prepareStatement("SELECT * FROM transactions WHERE accountId = ?");
            ps.setInt(1, accountId);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                Transaction transaction = new Transaction();
                transaction.setTransactionId(result.getInt("transactionId"));
                transaction.setAccountId(accountId);
                transaction.setDate(new java.util.Date(result.getTimestamp("date").getTime()));
                transaction.setSum(result.getDouble("sum"));
                transaction.setReceiverAccount(result.getInt("receiverAccount"));
                transactions.add(transaction);
            }
        } catch (SQLException e) {
            logger.error("SQL error " + e);
        } finally {
            try {
                if (ps != null)
                    ps.close();
            } catch (SQLException e) {
                logger.error("SQL error " + e);
            }
        }
        return transactions;
    }

    @Override
    public void addCardRequest(int clientId, TypeCard typeCard) {
        try (Connection conn = this.getDataSource().getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO cardrequests (date, clientId, typeCard) VALUES (?, ?, ?)")) {
            ps.setDate(1, Date.valueOf(java.time.LocalDate.now()));
            ps.setInt(2, clientId);
            ps.setString(3, String.valueOf(typeCard));
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.error("SQL error " + e);
        }
    }

    @Override
    public void approveRequest(int requestId) {
        try (Connection conn = this.getDataSource().getConnection();
        PreparedStatement ps = conn.prepareStatement("UPDATE cardrequests SET approval = ? WHERE requestId = ?")) {
            ps.setBoolean(1, true);
            ps.setInt(2, requestId);
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.error("SQL error " + e);
        }
    }


    @Override
    public void rejectRequest(int requestId) {
        try (Connection conn = this.getDataSource().getConnection();
        PreparedStatement ps = conn.prepareStatement("UPDATE cardrequests SET approval=? WHERE requestId=?")) {
            ps.setInt(1, 0);
            ps.setInt(2, requestId);
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.error("SQL error " + e);
        }
    }


}
