package ru.geekbrains.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.persist.Menu;
import ru.geekbrains.persist.repository.MenuRepository;
import ru.geekbrains.persist.repository.ItemRepository;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CatalogServlet", urlPatterns = "/catalog")
public class CatalogServlet extends HttpServlet {

    private Logger logger = LoggerFactory.getLogger(MenuRepository.class);

    private MenuRepository menuRepository;
    private ItemRepository itemRepository;

    @Override
    public void init() throws ServletException {
        ServletContext context = getServletContext();
        logger.info("CatalogServlet init - Ok");
        menuRepository = (MenuRepository) context.getAttribute("menuRepository");
        itemRepository = (ItemRepository) context.getAttribute("itemRepository");
        //userRepository = (UserRepository) context.getAttribute("userRepository");
        if (menuRepository == null) {
            throw new ServletException("Error. Menu not found");
        }


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("title", "Catalog");

        logger.info("CatalogServlet doGet - OK ");
        List<Menu> menu = menuRepository.fillMenu();
        request.setAttribute("menu", menu);

        //List<Display> displays = itemRepository.addDisplay();
        // request.setAttribute("displays", displays);
        //logger.info("CatalogServlet displays:" + displays.get(1).getName() );

        // List<Notebook> notebooks = itemRepository.addNotebook();
        //logger.info("CatalogServlet notebooks:" + notebooks.get(1).getName());
        // request.setAttribute("notebooks", notebooks);

        request.getRequestDispatcher("WEB-INF/VIEWS/catalog.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse
            response)
            throws ServletException, IOException {
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }
}