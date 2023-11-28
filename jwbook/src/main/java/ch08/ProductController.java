package ch08;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pcontrol")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductService service;
	
    public ProductController() {
    	service = new ProductService();
    }
    @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String action = request.getParameter("action");
    	String view = "";
    	
    	if(request.getParameter("action") == null) {
    		getServletContext().getRequestDispatcher("/pcontrol?action=list").forward(request, response);
    	} else {
    		switch(action) {
    		case "list": view = list(request, response); break;
    		case "info": view = info(request, response); break;
    		}
    		getServletContext().getRequestDispatcher("/ch08/"+view).forward(request, response);
    	}
    }
    
    private String list(HttpServletRequest request, HttpServletResponse response) {
    	request.setAttribute("products", service.findAll());
    	return "productList.jsp";
    }
    
    private String info(HttpServletRequest request, HttpServletResponse response) {
    	request.setAttribute("p", service.find(request.getParameter("id")));
    	return "productInfo.jsp";
    }
}
