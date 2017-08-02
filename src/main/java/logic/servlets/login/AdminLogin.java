package logic.servlets.login;

import logic.DAO.DAO;
import logic.DAO.DAODispatcher;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdminLogin", urlPatterns = "/sendAdminData")
public class AdminLogin extends HttpServlet {
    private static Logger logger = Logger.getLogger(AdminLogin.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAO dao = DAODispatcher.getDAO();
        if(dao.checkAdmin(request.getParameter("login"), request.getParameter("password"))) {
            request.getSession().setAttribute("login", request.getParameter("login"));
            request.getSession().setAttribute("password", request.getParameter("password"));
            logger.info(request.getParameter("login") + " was authorized");
            request.getRequestDispatcher("WEB-INF/forms/adminActionPage.jsp").forward(request, response);
        }
        else
            request.getRequestDispatcher("WEB-INF/deadends/noSuchAdmin.jsp").forward(request, response);

    }
}
