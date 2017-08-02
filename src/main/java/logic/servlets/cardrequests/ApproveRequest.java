package logic.servlets.cardrequests;

import logic.DAO;
import logic.DAODispatcher;
import logic.servlets.login.ClientLogin;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ApproveRequest", urlPatterns = "/approveRequest")
public class ApproveRequest extends HttpServlet {
    private static Logger logger = Logger.getLogger(ApproveRequest.class);
    DAO dao = DAODispatcher.getDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{

            dao.approveRequest(Integer.parseInt(request.getParameter("requestChoose")));
            logger.info("Request № " + request.getParameter("requestChoose") + " is approved");
            request.getRequestDispatcher("WEB-INF/deadends/requestApproved.jsp").forward(request,response);
        }
        catch (NumberFormatException e){
            request.getRequestDispatcher("WEB-INF/deadends/requestNotChoosen.jsp").forward(request,response);
        }
    }
}
