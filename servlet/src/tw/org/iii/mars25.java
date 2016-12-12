package tw.org.iii;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class mars25
 */
@WebServlet("/mars25")
public class mars25 extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private PrintWriter out;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mars25() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	   response.setContentType("text/html;charset=Utf8");
	   request.setCharacterEncoding("Utf8");
	   out=response.getWriter();
	   
	   Cookie[] cookies=request.getCookies();
	   if(cookies!=null){
		   for(Cookie cookie:cookies){
			   String name=cookie.getName();
			   String value=cookie.getValue();
			   out.print(name+":"+value+"<br />");
		   }
	   }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
