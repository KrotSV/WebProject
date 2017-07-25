package logics.servlets;

import logics.DAO;
import logics.ResourceManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BlockCard", urlPatterns = "/blockCard")
public class BlockCard extends HttpServlet {
    DAO dao = ResourceManager.getDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            dao.changeBlockStatus(Integer.parseInt(request.getParameter("cardChoose")), true);
            request.getRequestDispatcher("WEB-INF/block.jsp").forward(request, response);
        }
        catch (NumberFormatException ex){
            request.getRequestDispatcher("WEB-INF/cardNotChoose.jsp").forward(request, response);
        }
    }
}
