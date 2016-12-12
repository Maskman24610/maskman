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
 * Servlet implementation class mars33
 */
@WebServlet("/mars33")
public class mars33 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   private PrintWriter out;   
	   
	   
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				response.setContentType("text/html;charset=utf8");
				request.setCharacterEncoding("utf8");
			    out=response.getWriter();
			    
			    HttpSession session=request.getSession();
			    session.invalidate();
			    
			    out.println("mars33");
		}   

}
