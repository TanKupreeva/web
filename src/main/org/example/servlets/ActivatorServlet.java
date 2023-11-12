package main.org.example.servlets;

import main.org.example.jdbc.dao.impl.UserDAOImpl;
import main.org.example.servlets.model.User;
import main.org.example.util.EncryptDecryptUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/activate")
public class ActivatorServlet extends HttpServlet {

    private UserDAOImpl dao = new UserDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1 Get token value
        String token = req.getParameter("token");
        //
        String email = EncryptDecryptUtils.decrypt(token);
        //2. Check if it's valid Email at all
        User userFromDB = dao.findByEmail(email);
        if (userFromDB != null) {
            if (userFromDB.getIsActive()) {
                resp.getWriter().println("Already activated!");
            } else {
                // 3 Activate for new email
                dao.activate(userFromDB);
                resp.getWriter().println("Activated!");
            }
        } else {
            resp.getWriter().println("Incorrect user token");
        }

    }
}
