package controller;

import entity.Category;
import entity.Product;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session_bean.CategorySessionBean;
import session_bean.ProductSessionBean;

@WebServlet(name = "ControllerServlet",  urlPatterns = {"/ControllerServlet", "/category"})
public class ControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @EJB
    private ProductSessionBean productSessionBean;
    @EJB
    private CategorySessionBean categorySB;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userPath=request.getServletPath();
        if (userPath.equals("/category")) {
            String categoryId = request.getQueryString();
            if (categoryId != null){
                Category selectedCategory;
                List<Product> categoryProducts;
                selectedCategory = categorySB.find(Integer.parseInt(categoryId));
                request.getSession().setAttribute("selectedCategory", selectedCategory);
                categoryProducts = (List<Product>) selectedCategory.getProductCollection();
                request.getSession().setAttribute("categoryProducts", categoryProducts);
            }
        }
        String url = userPath + ".jsp";
        try{
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex){
            ex.printStackTrace();
        }


    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
