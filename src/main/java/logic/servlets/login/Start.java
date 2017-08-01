package logic.servlets.login;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Start", urlPatterns = "/start")
public class Start extends HttpServlet {
    private static Logger logger = Logger.getLogger(Start.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("i'm alive!");
        request.getRequestDispatcher("WEB-INF/login/start.jsp").forward(request,response);

    }
}
