package main.org.example.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class HomeServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("Init");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("service");
        super.service(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Server time : " + new Date());
        resp.getWriter().println("Hi there, this is Servlets response. " + new Date());
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("destroy");
    }
}
