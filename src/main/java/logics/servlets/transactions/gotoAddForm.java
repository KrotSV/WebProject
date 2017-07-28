package logics.servlets.transactions;

import logics.DAO;
import logics.ResourceManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "gotoAddForm", urlPatterns = "/addMoneyToCard")
public class gotoAddForm extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAO dao = ResourceManager.getDAO();
        try{
            request.getSession().setAttribute("cardNumber", Integer.parseInt(request.getParameter("cardChoose")));
            request.getSession().setAttribute("balance", dao.getAccount(Integer.parseInt(request.getParameter("cardChoose"))).getBalance());
            request.getSession().setAttribute("account", dao.getAccount(Integer.parseInt(request.getParameter("cardChoose"))));
            request.getRequestDispatcher("WEB-INF/addMoneyToCard.jsp").forward(request, response);
        }
        catch (NumberFormatException ex){}
        request.getRequestDispatcher("WEB-INF/cardNotChoose.jsp").forward(request, response);
    }
}
