package logic.servlets.login;

import entities.BankAccount;
import entities.Client;
import entities.CreditCard;
import logic.DAO;
import logic.ResourceManager;
import org.apache.log4j.Logger;


import java.io.IOException;
import java.util.ArrayList;

@javax.servlet.annotation.WebServlet(name = "ClientLogin", urlPatterns = "/sendClientData")
public class ClientLogin extends javax.servlet.http.HttpServlet {
    private DAO dao = ResourceManager.getDAO();
    private static Logger logger = Logger.getLogger(ClientLogin.class);

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
    if(dao.checkClientExistence(request.getParameter("firstName"), request.getParameter("lastName"))){
        Client client = dao.getClientData(request.getParameter("firstName"), request.getParameter("lastName"));

        ArrayList<CreditCard> cards = dao.getClientCards(client.getClientId());
        ArrayList<BankAccount> accounts = new ArrayList<>();

        request.getSession().setAttribute("birthday", client.getBirthday());
        request.getSession().setAttribute("firstName", client.getFirstName());
        request.getSession().setAttribute("lastName", client.getLastName());
        request.getSession().setAttribute("clientId", client.getClientId());
        request.getSession().setAttribute("cards", dao.getClientCards(client.getClientId()));

        for (CreditCard c:cards) {
            accounts.add(dao.getAccount(c.getCardNumber()));
        }
        request.getSession().setAttribute("accounts", accounts);
        request.getSession().setAttribute("client", client);
        System.out.println("Check");
        logger.info("Client connected: " + client.getFirstName() + " " + client.getLastName());
        request.getRequestDispatcher("WEB-INF/forms/clientDataPage.jsp").forward(request, response);

    }
    else {
        logger.info("Client not found" + "sasadas");
        request.getRequestDispatcher("WEB-INF/deadends/noSuchUser.jsp").forward(request, response);
    }
   }
}
