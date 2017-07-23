package logics.servlets;

import entities.Client;
import logics.DAO;
import logics.DAOmanager;

import java.io.IOException;

@javax.servlet.annotation.WebServlet(name = "ClientLogin", urlPatterns = "/sendClientData")
public class ClientLogin extends javax.servlet.http.HttpServlet {
    DAO dao = new DAOmanager().getDAO();

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
    if(dao.checkClientExistence(request.getParameter("firstName"), request.getParameter("lastName"))){
        Client client = dao.getClientData(request.getParameter("firstName"), request.getParameter("lastName"));
        request.setAttribute("client", client);
        request.getSession().setAttribute("client", client);request.getRequestDispatcher("WEB-INF/welcome.jsp").forward(request, response);
    }
   }
}
