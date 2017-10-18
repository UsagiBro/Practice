import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/part3_clear")
public class Part3Clear extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("list") != null) {
            List<String> list = (List<String>) session.getAttribute("list");
            list.clear();
            session.setAttribute("list", list);
        }
        req.getRequestDispatcher("part3").forward(req, resp);
    }
}
