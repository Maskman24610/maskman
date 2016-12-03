package tw.org.iii;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class mars09
 */
@WebServlet("/mars09")
public class mars09 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mars09() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
       response.setContentType("text/html;charset=Utf-8");
       
       //針對中文檔名處理 必須在任何request和response之前作設定
       request.setCharacterEncoding("Utf-8");
       response.setCharacterEncoding("Utf-8");
       
       PrintWriter out=response.getWriter();
	
       RequestDispatcher dispatcher=
    		   request.getRequestDispatcher("mars10?name=mars&price=123");
	   out.println("<h1>Mars Big Company</h1>");
	   dispatcher.include(request,response);
	   out.println("<hr>");
	   out.println("Copyleft");
//		out.print("<hr>");
//		dispatcher.include(request, response);
//		out.println("<hr>");
//		out.println("Copyleft");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
