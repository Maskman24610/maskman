package tw.org.iii;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class mars32
 */
@WebServlet("/mars32")
public class mars32 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   private PrintWriter out;   
	   private myCart mycart;
	   
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				response.setContentType("text/html;charset=utf8");
				request.setCharacterEncoding("utf8");
			    out=response.getWriter();
			    
			    HttpSession session=request.getSession();
			    String name=(String) session.getAttribute("name");
			    Integer Lottery=(Integer) session.getAttribute("lottery");
			    mycart=(myCart)session.getAttribute("cart");
			    if(name==null){
			    	response.sendRedirect("mars30");
			    	return;
			    }
			    
			    out.println("mars32<br>");
			    HashMap<String,Integer> buylist=mycart.getBuyList();
			    Set<String> items=buylist.keySet();
			    for(String itemname:items){
			    	out.print(itemname+"=>"+buylist.get(itemname)+"<br />");
			    }
			    out.print("<hr>"+"<a href='mars33'>Logout");
		}
        
}
