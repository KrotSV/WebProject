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

@WebServlet(name = "adjunctionOperation", urlPatterns = "/addBalance")
public class adjunctionOperation extends HttpServlet {
    private static Logger logger = Logger.getLogger(adjunctionOperation.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            DAO dao = DAODispatcher.getDAO();
            BankAccount account = (BankAccount)request.getSession().getAttribute("account");
            if(!account.getStatus()) {
                logger.info("The card balance was replenished successfully");
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
