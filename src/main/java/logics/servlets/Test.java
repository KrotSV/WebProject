package logics.servlets;

import com.mysql.fabric.jdbc.FabricMySQLDriver;
import entities.Client;
import logics.DAO;
import logics.ResourceManager;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

@WebServlet(name = "Test", urlPatterns = "/TestDB")
public class Test extends HttpServlet {
    DAO dao = ResourceManager.getDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        int test = dao.testDB();
        System.out.println(test);
        request.getSession().setAttribute("test", test);
        request.getRequestDispatcher("WEB-INF/test.jsp").forward(request,response);
    }
}
