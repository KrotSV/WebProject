package logics.servlets.transactions;

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
            BankAccount account = (BankAccount)request.getSession().getAttribute("account");
            if(!account.getStatus()) {
                dao.balanceOperation(Integer.parseInt(request.getParameter("cardNumber")), Double.parseDouble(request.getParameter("sum")), account.getAccountId());
                request.getRequestDispatcher("WEB-INF/deadends/operationSuccsessful.jsp").forward(request, response);
            }
            else
                request.getRequestDispatcher("WEB-INF/deadends.cardIsBlocked.jsp").forward(request,response);
        } catch (NumberFormatException ex) {
            request.getRequestDispatcher("WEB-INF/deadends/notCorrectData.jsp").forward(request, response);
        }
    }
}
