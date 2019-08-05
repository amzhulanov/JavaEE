package ru.geekbrains.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.persist.Menu;
import ru.geekbrains.persist.MenuRepository;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "CatalogServlet", urlPatterns = "/catalog")
public class CatalogServlet extends HttpServlet {

    private Logger logger = LoggerFactory.getLogger(MenuRepository.class);

    private MenuRepository menuRepository;

    @Override
    public void init() throws ServletException {
        ServletContext context = getServletContext();
        logger.info("task 1 init menuRepository AAAAAAAAAAAAAAAAAAAAAAAAAA");
        menuRepository=(MenuRepository) context.getAttribute("menuRepository");
        logger.info("task 2 init menuRepository"+menuRepository.toString()+" AAAAAAAAAAAAAAAAAAAAAAAAAA");
        //userRepository = (UserRepository) context.getAttribute("userRepository");
        if (menuRepository == null) {
            throw new ServletException("Error. Menu not found");
        }


    }

    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse           response)            throws ServletException, IOException {
        logger.info("task 1 fill Menu AAAAAAAAAAAAAAAAAAAAAAAAAA");
        String id = request.getParameter("id");
        logger.info("task 2 getParametr="+id+" AAAAAAAAAAAAAAAAAAAAAA");
        logger.info("task 3 getParametr="+menuRepository.toString()+" AAAAAAAAAAAAAAAAAAAAAA");
        //processRequest(request, response);
        List<Menu> menu=menuRepository.fillMenu();

        logger.info("task 4 fill Menu AAAAAAAAAAAAAAAAAAAAAAAAAA");

        request.setAttribute("title","Catalog");
        logger.info("task 5 setAttribute title - OK ");
        request.setAttribute("menu",menu);
        logger.info("task 6 setAttribute menu - OK ");
        request.getRequestDispatcher("WEB-INF/VIEWS/catalog.jsp").forward(request,response);
    }


 /*   protected void processRequest (HttpServletRequest request,
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
            out.println( "<a href='product'>Продукты</a><br>" );
            out.println( "<a href='cart'>Корзина</a><br>" );
            out.println( "<a href='order'>История заказов</a><br>" );
            out.println( "</body>" );
            out.println( "</html>" );
        }
    }*/




    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse
            response)
            throws ServletException, IOException
    {
//        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
