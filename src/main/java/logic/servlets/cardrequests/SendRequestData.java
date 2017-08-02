package logic.servlets.cardrequests;

import entities.TypeCard;
import logic.DAO.DAO;
import logic.DAO.DAODispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SendRequestData", urlPatterns = "/sendRequestData")
public class SendRequestData extends HttpServlet {
    DAO dao = DAODispatcher.getDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dao.addCardRequest((Integer)(request.getSession().getAttribute("clientId")), TypeCard.valueOf(request.getParameter("typeChose")));
        request.getRequestDispatcher("WEB-INF/deadends/operationSuccsessful.jsp").forward(request,response);
    }
}
