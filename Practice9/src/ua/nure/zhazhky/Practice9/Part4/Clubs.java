package ua.nure.zhazhky.Practice9.Part4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/clubs")
public class Clubs extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("user");
        String club = req.getParameter("club");
        req.setAttribute("user", user);
        req.setAttribute("club", club);
        req.getRequestDispatcher("/part2.jsp").forward(req, resp);
    }
}
