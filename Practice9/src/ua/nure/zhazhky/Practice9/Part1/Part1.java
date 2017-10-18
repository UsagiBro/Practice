package ua.nure.zhazhky.Practice9.Part1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/calc")
public class Part1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String x = req.getParameter("x");
        String y = req.getParameter("y");
        String op = req.getParameter("op");
        int answer = 0;
        switch (op) {
            case "plus":
                answer = Integer.valueOf(x) + Integer.valueOf(y);
                break;
            case "minus":
                answer = Integer.valueOf(x) - Integer.valueOf(y);
                break;
        }
        req.setAttribute("answer", answer);
        req.getRequestDispatcher("/answer.jsp").forward(req, resp);
    }
}
