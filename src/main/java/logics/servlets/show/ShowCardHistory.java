package logics.servlets.show;

import entities.Client;
import entities.Transaction;
import logics.DAO;
import logics.ResourceManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

@WebServlet(name = "ShowCardHistory", urlPatterns = "/showHistory")
public class ShowCardHistory extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAO dao = ResourceManager.getDAO();
        try{
            LinkedList<Transaction> history = dao.getHistory(Integer.parseInt(request.getParameter("cardChoose")));
            request.getSession().setAttribute("cardNumber", Integer.parseInt(request.getParameter("cardChoose")));
            request.getSession().setAttribute("balance", dao.getAccount(Integer.parseInt(request.getParameter("cardChoose"))).getBalance());
            request.setAttribute("history", history);
            request.getRequestDispatcher("WEB-INF/cardHistory.jsp").forward(request, response);
        }
        catch (NumberFormatException ex){
            request.getRequestDispatcher("WEB-INF/cardNotChoose.jsp").forward(request, response);
        }

    }
}
