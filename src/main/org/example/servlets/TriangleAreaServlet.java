package main.org.example.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/triangle")
public class TriangleAreaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String aParam = req.getParameter("a");
        String bParam = req.getParameter("b");
        String cParam = req.getParameter("c");
        PrintWriter pw = resp.getWriter();

        double a = Double.valueOf(aParam);
        double b = Double.valueOf(bParam);
        double c = Double.valueOf(cParam);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        if ((a + b) > c && (a + c) > b && (b + c) > a) {
            double p = (a + b + c) / 2;
            double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
            pw.println("Area is " + s);

        } else {
            pw.println("There is no triangle");
        }
    }


}
