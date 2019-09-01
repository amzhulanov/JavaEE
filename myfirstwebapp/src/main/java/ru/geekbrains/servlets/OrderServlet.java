package ru.geekbrains.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.persist.Menu;
import ru.geekbrains.persist.repository.MenuRepository;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "OrderServlet", urlPatterns = "/order")
public class OrderServlet extends HttpServlet {


    private Logger logger = LoggerFactory.getLogger(MenuRepository.class);

    private MenuRepository menuRepository;

    @Override
    public void init() throws ServletException {
        ServletContext context = getServletContext();
        logger.info("OrderServlet init - Ok");
        menuRepository = (MenuRepository) context.getAttribute("menuRepository");
        //userRepository = (UserRepository) context.getAttribute("userRepository");
        if (menuRepository == null) {
            throw new ServletException("Error. Menu not found");
        }

    }

    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse           response)            throws ServletException, IOException {
        logger.info("OrderServlet doGet - OK ");
        String id = request.getParameter("id");
        List<Menu> menu = menuRepository.fillMenu();
        request.setAttribute("title", "Order");
        request.setAttribute("menu", menu);
        request.getRequestDispatcher("WEB-INF/VIEWS/order.jsp").forward(request, response);
    }

        @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse
            response)
            throws ServletException, IOException
    {
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
