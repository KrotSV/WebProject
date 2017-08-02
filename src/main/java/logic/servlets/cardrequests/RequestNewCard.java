package logic.servlets.cardrequests;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RequestNewCard", urlPatterns = "/requestNewCard")
public class RequestNewCard extends HttpServlet {
    private static Logger logger = Logger.getLogger(RequestNewCard.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("Request created");
        request.getRequestDispatcher("WEB-INF/forms/createRequest.jsp").forward(request, response);
    }
}
