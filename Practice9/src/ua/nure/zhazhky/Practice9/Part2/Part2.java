package ua.nure.zhazhky.Practice9.Part2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/part2")
public class Part2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String entered = req.getParameter("entered");
        req.setAttribute("result", entered);
        System.out.println(entered);
        req.getRequestDispatcher("/result.jsp").forward(req, resp);
    }
}
