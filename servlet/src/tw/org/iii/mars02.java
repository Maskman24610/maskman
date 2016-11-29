package tw.org.iii;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class mars02
 */
@WebServlet("/mars02")
public class mars02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mars02() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		 int x,y,remainder,op;
		 String result="";
		 try{
		   x=Integer.parseInt(request.getParameter("x"));
		   op=Integer.parseInt(request.getParameter("op"));
		   y=Integer.parseInt(request.getParameter("y"));
		 }
		 catch(Exception e){
			 x=0;
			 y=0;
			 op=0;
			 remainder=0;
		 }
		 
		 switch(op){
		   case 1: result=Integer.toString(x+y);break;
		   case 2:result=Integer.toString(x-y);break;
		   case 3:result=Integer.toString(x*y);break;
		   case 4:
			   remainder=x%y;
			   String quotient=Integer.toString(x/y);
			   if(remainder!=0){
			      result=quotient+"......"+Integer.toString(remainder);
			   }
			   else{
				   result=quotient;
			   }
			   break;
		 }
		//try{
		response.setContentType("text/html;charset=Utf-8");
		 PrintWriter out=response.getWriter();
		 out.println("<form>");
		 out.println("<input type='text' name='x'  value='"+x+"'/>");
		 out.println("<select name='op'>");
		 out.println("<option value='1'>+</option>");
		 out.println("<option value='2'>-</option>");
		 out.println("<option value='3'>x</option>");
		 out.println("<option value='4'>/</option>");
		 out.println("<input type='text' name='y' value='"+y+"'/>");
		 out.println("<input type='submit' value='=' />");
		
		 out.println("<span>"+result+"</span>");
		 out.println("</form>");
		 out.flush();
		 out.close();
	  // }
	   //catch(Exception e){
		  // e.toString();
	   //}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
