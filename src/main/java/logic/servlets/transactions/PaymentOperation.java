package logic.servlets.transactions;

import entities.BankAccount;
import logic.DAO;
import logic.ResourceManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PaymentOperation", urlPatterns = "/paymentSend")
public class PaymentOperation extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            DAO dao = ResourceManager.getDAO();
            BankAccount account = dao.getAccount(Integer.parseInt(request.getParameter("cardNumber")));
            if(account.getStatus())
                request.getRequestDispatcher("WEB-INF/deadends.cardIsBlocked.jsp").forward(request,response);
            else {
                if (account.getBalance() - Double.parseDouble(request.getParameter("sum")) < account.getLimit()) {
                    request.getRequestDispatcher("WEB-INF/deadends/notEnoughMoney.jsp").forward(request, response);
                } else {
                    dao.balanceOperation(Integer.parseInt(request.getParameter("cardNumber")), -Double.parseDouble(request.getParameter("sum")), Integer.parseInt(request.getParameter("receiver")));
                    request.getRequestDispatcher("WEB-INF/deadends/operationSuccsessful.jsp").forward(request, response);
                }
            }
        }
        catch (Exception ex){
            request.getRequestDispatcher("WEB-INF/deadends/notCorrectData.jsp").forward(request,response);
        }
    }
}
