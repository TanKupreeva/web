package main.org.example.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/random")
public class RandomServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        int min  = 0;
//        int max = 1000;
        String minParam = req.getParameter("min");
        String maxParam = req.getParameter("max");
        PrintWriter pw = resp.getWriter();
        int max = Integer.valueOf(maxParam);
        int min;
        if (minParam == null) {
            min = 0;
        } else min = Integer.valueOf(minParam);

        int result = (int)(Math.random() * (max - min + 1)) + min;
        pw.println("Result:");
        pw.println(result);
    }

}

