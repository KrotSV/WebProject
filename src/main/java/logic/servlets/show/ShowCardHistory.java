package logic.servlets.show;

import entities.Transaction;
import logic.DAO;
import logic.ResourceManager;

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
//            LinkedList<Date> dates = new LinkedList<>();
//            for (Transaction t:history) {
//                Date date = t.getDate();
//                dates.add(date);
//            }
//
//            request.getSession().setAttribute("dates", dates);
//            System.out.println(dates);
            request.getSession().setAttribute("cardNumber", Integer.parseInt(request.getParameter("cardChoose")));
            request.getSession().setAttribute("balance", dao.getAccount(Integer.parseInt(request.getParameter("cardChoose"))).getBalance());
            request.getSession().setAttribute("history", history);
            request.getRequestDispatcher("WEB-INF/infopages/cardHistory.jsp").forward(request, response);
        }
        catch (NumberFormatException ex){
            request.getRequestDispatcher("WEB-INF/deadends/cardNotChoose.jsp").forward(request, response);
        }

    }
}
