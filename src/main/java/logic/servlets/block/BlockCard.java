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

@WebServlet(name = "BlockCard", urlPatterns = "/blockCard")
public class BlockCard extends HttpServlet {
    DAO dao = DAODispatcher.getDAO();
    private static Logger logger = Logger.getLogger(BlockCard.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            dao.changeBlockStatus(Integer.parseInt(request.getParameter("cardChoose")), true);
            logger.info("Card № " + request.getParameter("cardChoose") + " is blocked");
            request.getRequestDispatcher("WEB-INF/deadends/block.jsp").forward(request, response);
        }
        catch (NumberFormatException ex){
            request.getRequestDispatcher("WEB-INF/deadends/cardNotChoosen.jsp").forward(request, response);
        }
    }
}
