package logics;

import java.io.IOException;

@javax.servlet.annotation.WebServlet(name = "WelcomeServlet", urlPatterns = "/login")
public class WelcomeServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
    request.getRequestDispatcher("WEB-INF/welcome.jsp").forward(request, response);
    }
}
