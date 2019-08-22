package ru.geekbrains.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Error404Handler extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }



    protected void processRequest (HttpServletRequest request, HttpServletResponse
            response)
            throws ServletException, IOException {
        response.setContentType( "text/html;charset=UTF-8" );
        try (PrintWriter out = response.getWriter()) {
            out.println( "<!DOCTYPE html>" );
            out.println( "<html>" );
            out.println( "<head>" );
            out.println( "<title>Ошибка!</title>" );
            out.println( "</head>" );
            out.println( "<body>" );
            out.println( "<h1>Ошибка 404. Страница не найдена!</h1>" );
            out.println( "</body>" );
            out.println( "</html>" );
        }
    }
}
