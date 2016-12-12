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
 * Servlet implementation class mars24
 */
@WebServlet("/mars24")
public class mars24 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PrintWriter out;    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mars24() {
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
	    out=response.getWriter();
	    
	    Cookie cookie1=new Cookie("name","mars");
	    cookie1.setMaxAge(10*60);
	    response.addCookie(cookie1);
	    
	    Cookie cookie2=new Cookie("password","235813");
	    cookie2.setMaxAge(10*60);
	    response.addCookie(cookie2);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
