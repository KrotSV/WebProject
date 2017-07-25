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

@WebServlet(name = "PaymentOperation", urlPatterns = "/paymentSend")
public class PaymentOperation extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        try{
            DAO dao = ResourceManager.getDAO();
            BankAccount account = dao.getAccount(Integer.parseInt(request.getParameter("cardChoose")));
            request.getSession().setAttribute("cardChoose", Integer.parseInt(request.getParameter("cardChoose")));
            if(account.getBalance() - Double.parseDouble(request.getParameter("sum")) < account.getLimit()){
                request.getRequestDispatcher("WEB-INF/notEnoughMoney.jsp").forward(request,response);
            }
            else {
                dao.balanceOperation(Integer.parseInt(request.getParameter("cardChoose")), - Double.parseDouble(request.getParameter("sum")));
                dao.addTransaction((Integer)request.getSession().getAttribute("cardChoose"), Double.parseDouble(request.getParameter("sum")));
                request.getRequestDispatcher("WEB-INF/operationSuccsessful.jsp").forward(request,response);
            }
        }
//        catch (Exception ex){
//            request.getRequestDispatcher("WEB-INF/notCorrectData.jsp").forward(request,response);
//        }
//    }
}
