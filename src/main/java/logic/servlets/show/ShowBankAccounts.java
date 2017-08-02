package logic.servlets.show;

import entities.BankAccount;
import entities.Client;
import entities.CreditCard;
import logic.DAO.DAO;
import logic.DAO.DAODispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ShowBankAccounts", urlPatterns = "/sendClientDataByAdmin")
public class ShowBankAccounts extends HttpServlet {
    private DAO dao = DAODispatcher.getDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            if (dao.checkClientExistence(request.getParameter("firstName"), request.getParameter("lastName"))) {
                Client client = dao.getClientData(request.getParameter("firstName"), request.getParameter("lastName"));

                ArrayList<CreditCard> cards = dao.getClientCards(client.getClientId());
                ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
                request.getSession().setAttribute("cards", cards);


                for (CreditCard c : cards) {
                    accounts.add(dao.getAccount(c.getCardNumber()));
                }
                request.getSession().setAttribute("accounts", accounts);
                request.getSession().setAttribute("client", client);
                request.getSession().setAttribute("firstName", request.getParameter("firstName"));
                request.getSession().setAttribute("lastName", request.getParameter("lastName"));

                request.getRequestDispatcher("WEB-INF/forms/clientAccounts.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("WEB-INF/deadends/noSuchClient.jsp").forward(request, response);
            }
        }
        catch (Exception ex){
            request.getRequestDispatcher("WEB-INF/deadends/noSuchClient.jsp").forward(request, response);
        }
    }

}
