package logics.servlets.transactions;

import logics.DAO;
import logics.ResourceManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "gotoPaymentForm", urlPatterns = "/payCard")
public class gotoPaymentForm extends HttpServlet {

    private DAO dao = ResourceManager.getDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.getSession().setAttribute("cardNumber", Integer.parseInt(request.getParameter("cardChoose")));
            request.getSession().setAttribute("balance", dao.getAccount(Integer.parseInt(request.getParameter("cardChoose"))).getBalance());
            request.getRequestDispatcher("WEB-INF/payment.jsp").forward(request, response);
        }
        catch (NumberFormatException ex){
            request.getRequestDispatcher("WEB-INF/cardNotChoose.jsp").forward(request, response);
        }
    }
}
