package logic.servlets.block;

import logic.DAO;
import logic.DAODispatcher;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ChangeCardStatus", urlPatterns = "/changeCardStatus")
public class ChangeCardStatus extends HttpServlet {
    private static Logger logger = Logger.getLogger(ChangeCardStatus.class);
    DAO dao = DAODispatcher.getDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("Card № " + request.getParameter("cardChoose") + " is unblocked");
        dao.changeBlockStatus(Integer.parseInt(request.getParameter("cardChoose")), false);
        request.getRequestDispatcher("WEB-INF/deadends/statusChanged.jsp").forward(request,response);
    }
}
