package tw.org.iii;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class mars11
 */
@WebServlet("/mars11")
public class mars11 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mars11() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	    //response.setContentType("text/html;charset=utf-8");
	    //0.prepare
	    String x=request.getParameter("x");
	    String y=request.getParameter("y");
	    if(x==null) x="0";
	    if(y==null) y="0";
	    
	    //1Model
	    mars12 mar=new mars12();
	    String res=mar.cal(x, y);
	    //HashMap<String,String> res2=mar.cal(request);
	    //System.out.println(x+"+"+y+"="+res);
	    
	    //2.forward=>mars07
	    request.setAttribute("x", x);
	    request.setAttribute("y",y);
	    request.setAttribute("res", res);
	    request.getRequestDispatcher("mars13").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
