package controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.ProductBLL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;

@WebServlet(name = "ControllerServlet",  loadOnStartup = 1,  urlPatterns = { "/ControllerServlet" })
public class ControllerServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		// TODO Auto-generated method stub
		super.init(servletConfig);
		ProductBLL productBLL=new ProductBLL();
            try {

                getServletContext().setAttribute("newProducts", productBLL.getNewProducts(5));
            } catch (NamingException ex) {
                Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
