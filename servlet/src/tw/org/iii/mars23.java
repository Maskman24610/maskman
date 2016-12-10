package tw.org.iii;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class mars23
 */
@WebServlet("/mars23")
public class mars23 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub

       //response.sendRedirect("http://www.ncku.edu.tw");
      response.sendError(HttpServletResponse.SC_BAD_GATEWAY,"你好宅");
    }
}
