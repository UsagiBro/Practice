import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/part4")
public class Part4 extends HttpServlet {

    static final String GET_USER = "SELECT * FROM users WHERE login = ? AND password = ?";
    static final String GET_ROLE = "SELECT * FROM roles WHERE id = ?";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String roleId = null;
        HttpSession session = req.getSession();
        if (login == null || password == null) {
            req.getRequestDispatcher("/part4.jsp").forward(req, resp);
        }
        try {
            // obtain an environment naming context
            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            // look up a data source
            DataSource ds = (DataSource) envCtx.lookup("jdbc/practice10");
            // obtain a connection from the pool
            Connection con = ds.getConnection();

            try {
                PreparedStatement statement = con.prepareStatement(GET_USER);
                statement.setString(1, login);
                statement.setString(2, password);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    session.setAttribute("login", resultSet.getString("login"));
                    roleId = resultSet.getString("role_id");
                }
            } catch (SQLException e) {
                req.getRequestDispatcher("/part4.jsp").forward(req, resp);
            }

            try {
                PreparedStatement statement = con.prepareStatement(GET_ROLE);
                statement.setString(1, roleId);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    session.setAttribute("role", resultSet.getString("name"));
                    req.getRequestDispatcher("/part3.jsp").forward(req, resp);
                }
            } catch (SQLException e) {
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            }
            con.close();
        } catch (NamingException | SQLException ex) {
            // log an exception to a console
            ex.printStackTrace();

            // send an exception to a client
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace(pw);
            resp.getWriter().println(sw);
        }
    }


}
