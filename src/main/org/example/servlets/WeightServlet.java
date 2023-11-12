package main.org.example.servlets;

import main.org.example.util.Planet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static main.org.example.util.Planet.EARTH;

@WebServlet("/weight")
public class WeightServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/weight-calc-form.html");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int weight = Integer.valueOf(req.getParameter("weight"));
        String planet = req.getParameter("planets");
        double earthWeight = Double.parseDouble(String.valueOf(weight));
        double mass = earthWeight / EARTH.surfaceGravity();
        PrintWriter pw = resp.getWriter();

        for (Planet p : Planet.values()) {
            if (planet.equals(p.toString())) {
                System.out.println("Weight in " + planet + " is " + Planet.valueOf(planet).surfaceWeight(mass));
                pw.println("Weight in " + planet + " is " + Planet.valueOf(planet).surfaceWeight(mass) + " kg");

            }
        }
    }
}
