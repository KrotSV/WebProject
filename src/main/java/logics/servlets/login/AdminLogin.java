package logics.servlets.login;

import logics.DAO;
import logics.ResourceManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdminLogin", urlPatterns = "/sendAdminData")
public class AdminLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAO dao = ResourceManager.getDAO();
        if(dao.checkAdmin(request.getParameter("login"), request.getParameter("password"))) {
            request.getSession().setAttribute("login", request.getParameter("login"));
            request.getSession().setAttribute("password", request.getParameter("password"));
            request.getRequestDispatcher("WEB-INF/forms/adminActionPage.jsp").forward(request, response);
        }
        else
            request.getRequestDispatcher("WEB-INF/deadends/noSuchAdmin.jsp").forward(request, response);

    }
}
