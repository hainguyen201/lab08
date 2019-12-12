package listener;
import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import session_bean.CategorySessionBean;
import session_bean.ProductSessionBean;
public class ControllerServletListener implements ServletContextListener {
    @EJB
    ProductSessionBean productSessionBean;
    @EJB
    CategorySessionBean categorySessionBean;  
    ServletContext context;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        context = sce.getServletContext();
        context.setAttribute("categories", categorySessionBean.findRange(new int[] {0,5}));
        context.setAttribute("newProducts", productSessionBean.findRange(new int[] {0,5}));
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        this.context = null;
    }
}

