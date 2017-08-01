package logic.servlets.cardrequests;

import logic.DAO;
import logic.ResourceManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RejectRequest", urlPatterns = "/rejectRequest")
public class RejectRequest extends HttpServlet {
    DAO dao = ResourceManager.getDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            dao.rejectRequest(Integer.parseInt(request.getParameter("requestChoose")));
            request.getRequestDispatcher("WEB-INF/deadends/requestRejected.jsp").forward(request,response);
        }
        catch (NumberFormatException e){
            request.getRequestDispatcher("WEB-INF/deadends/requestNotChoosen.jsp").forward(request,response);
        }
    }
}
