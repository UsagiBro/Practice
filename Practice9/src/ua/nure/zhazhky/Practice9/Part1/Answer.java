package ua.nure.zhazhky.Practice9.Part1;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/answer")
public class Answer extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object answer = req.getAttribute("answer");
        req.getRequestDispatcher("/calc.jsp").forward(req, resp);
    }
}
