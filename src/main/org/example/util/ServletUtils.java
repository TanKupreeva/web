package main.org.example.util;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class ServletUtils {
    public static void info(HttpServletRequest request, String msg){
        request.getMethod();
        request.getContextPath();
        request.getPathInfo();
        request.getServletPath();
        request.getRequestURI();
        request.getRequestURL();
        System.out.println(String.format("%s INFO [%s] Method: %s | Path: %s | %s",
                new Date().toString(),Thread.currentThread().getName(),request.getMethod(),
                request.getServletPath(), msg));
    }
}
