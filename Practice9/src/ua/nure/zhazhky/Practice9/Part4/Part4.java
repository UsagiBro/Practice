package ua.nure.zhazhky.Practice9.Part4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/part4")
public class Part4 extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("user");
        String club = req.getParameter("club");
        Map map = new HashMap<String, String>();
        String[] clubs = getServletContext().getInitParameter("list").split(" ");
        req.setAttribute("user", user);
        req.setAttribute("club", club);
        req.getRequestDispatcher("/clubs.jsp").forward(req, resp);
    }
}
