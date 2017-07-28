package logics.servlets.cardrequests;

import entities.CardRequest;
import logics.DAO;
import logics.ResourceManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

@WebServlet(name = "ShowRequests", urlPatterns = "/checkRequests")
public class ShowRequests extends HttpServlet {
    DAO dao = ResourceManager.getDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LinkedList<CardRequest> requests = dao.getRequests();
        request.getSession().setAttribute("requests", requests);
        request.getRequestDispatcher("WEB-INF/infopages/showRequests.jsp").forward(request,response);
    }
}
