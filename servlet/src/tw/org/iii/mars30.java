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
 * Servlet implementation class mars30
 */
@WebServlet("/mars30")
public class mars30 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PrintWriter out;   
    private myCart mycart;  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html;charset=utf8");
			request.setCharacterEncoding("utf8");
		    out=response.getWriter();
		    
		    out.println("mars30<hr>");
		    int Lottery=(int) (Math.random()*49+1);
		    mycart=new myCart("許用");
		    out.print("Lottery:"+Lottery+"<br />");
		    
		    //
		    HttpSession session=request.getSession();
		    //session.setMaxInactiveInterval(10);           //帶的數字代表秒數
		    session.setAttribute("name","許用");
		    session.setAttribute("lottery", Lottery);           //Lottery (int) =>autoboxing=>Integer
		    session.setAttribute("cart",mycart );
		    
		    out.print("<a href='mars31'>Go to mars31");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
