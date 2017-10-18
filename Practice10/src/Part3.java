import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/part3")
public class Part3 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String name = req.getParameter("name");
        if (name != null && !name.equals("")) {
            if (session.getAttribute("list") == null) {
                List<String> list = new ArrayList<>();
                list.add(name);
                session.setAttribute("list", list);
            } else {
                List<String> list = (List<String>) session.getAttribute("list");
                list.add(name);
                session.setAttribute("list", list);
            }
        }
        resp.sendRedirect("part3");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("part3.jsp").forward(req, resp);
    }
}
