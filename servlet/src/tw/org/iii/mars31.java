package tw.org.iii;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class mars31
 */
@WebServlet("/mars31")
public class mars31 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   private PrintWriter out;   
	   private myCart mycart;
	   
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				response.setContentType("text/html;charset=utf8");
				request.setCharacterEncoding("utf8");
			    out=response.getWriter();
			    
			    //取得Session記錄的資料
			    HttpSession session=request.getSession();
			    String name=(String) session.getAttribute("name");
			    Integer Lottery=(Integer) session.getAttribute("lottery");
			    mycart=(myCart)session.getAttribute("cart");
			    if(name==null){
			    	response.sendRedirect("mars30");
			    	return;
			    }
			    
			    out.println("mars31<hr>");
			    out.print(name+":"+Lottery+"<br />");
			    out.print("<a href='mars32'>Go mars32<br />");
			    out.print("<a href='mars33'>Logout");
			    
			    mycart.addItem("apple", 14);
			    mycart.addItem("pen", 20);
			    mycart.addItem("pineapple", 13);
		}   
 

}
