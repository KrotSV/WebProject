package logic.servlets.transactions;

import entities.BankAccount;
import logic.DAO.DAO;
import logic.DAO.DAODispatcher;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PaymentOperation", urlPatterns = "/paymentSend")
public class PaymentOperation extends HttpServlet {
    private static Logger logger = Logger.getLogger(PaymentOperation.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            DAO dao = DAODispatcher.getDAO();
            BankAccount account = dao.getAccount(Integer.parseInt(request.getParameter("cardNumber")));
            if(account.getStatus())
                request.getRequestDispatcher("WEB-INF/deadends/cardIsBlocked.jsp").forward(request,response);
            else {
                logger.info("Operation failed: not enough money. Card № " + request.getParameter("cardNumber"));
                if (account.getBalance() - Double.parseDouble(request.getParameter("sum")) < account.getLimit()) {
                    request.getRequestDispatcher("WEB-INF/deadends/notEnoughMoney.jsp").forward(request, response);
                } else {
                    logger.info("Payment successful. Card № " + request.getParameter("cardNumber"));
                    dao.balanceOperation(Integer.parseInt(request.getParameter("cardNumber")), -Double.parseDouble(request.getParameter("sum")), Integer.parseInt(request.getParameter("receiver")));
                    request.getRequestDispatcher("WEB-INF/deadends/operationSuccsessful.jsp").forward(request, response);
                }
            }
        }
        catch (NumberFormatException ex){
            request.getRequestDispatcher("WEB-INF/deadends/notCorrectData.jsp").forward(request,response);
        }
    }
}
