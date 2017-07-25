package logics.servlets;

import entities.BankAccount;
import logics.DAO;
import logics.ResourceManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "adjunctionOperation", urlPatterns = "/addBalance")
public class adjunctionOperation extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            DAO dao = ResourceManager.getDAO();
            BankAccount account = dao.getAccount(Integer.parseInt(request.getParameter("cardChoose")));
            request.getSession().setAttribute("cardChoose", Integer.parseInt(request.getParameter("cardChoose")));
            dao.getAccount(Integer.parseInt(request.getParameter("cardChoose"))).setBalance(account.getBalance() + Double.parseDouble(request.getParameter("sum")));
            dao.addTransaction((Integer) request.getSession().getAttribute("cardChoose"), Double.parseDouble(request.getParameter("sum")));
            request.getRequestDispatcher("WEB-INF/operationSuccsessful.jsp").forward(request, response);

        } catch (Exception ex) {
            request.getRequestDispatcher("WEB-INF/notCorrectData.jsp").forward(request, response);
        }
    }
}
