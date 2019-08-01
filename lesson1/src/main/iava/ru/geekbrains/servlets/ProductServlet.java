package ru.geekbrains.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse           response)            throws ServletException, IOException {
        processRequest(request, response);
    }


    protected void processRequest (HttpServletRequest request,
                                   HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            out.println( "<!DOCTYPE html>" );
            out.println( "<html>" );
            out.println( "<head>" );
            out.println( "<title>" + request.getServletPath()+"</title>");
            out.println( "</head>" );
            out.println( "<body>" );
            out.println( "<h1>It`s "+request.getServletPath()+" page</h1>" );
            out.println( "<a href='mainpage'>На главную</a><br>" );
            out.println( "<a href='catalog'>Каталог</a><br>" );
            out.println( "<a href='cart'>Корзина</a><br>" );
            out.println( "<a href='order'>История заказов</a><br>" );
            out.println( "</body>" );
            out.println( "</html>" );
        }
    }

    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse
            response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
