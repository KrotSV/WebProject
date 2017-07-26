package logics.servlets;

import logics.DAO;
import logics.ResourceManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ApproveRequest", urlPatterns = "/approveRequest")
public class RejectRequest extends HttpServlet {
    DAO dao = ResourceManager.getDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dao.rejectRequest(Integer.parseInt(request.getParameter("requestChoose")));
        request.getRequestDispatcher("WEB-INF/requestRejected.jsp").forward(request,response);
    }
}
