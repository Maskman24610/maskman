package tw.org.iii;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class mars01
 */
@WebServlet("/mars01.php")
public class mars01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    @Override
//    public void service(ServletRequest request,ServletResponse response) throws ServletException,IOException{
//    	
//    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	   System.out.println("doGet");
	   doTask(request,response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		System.out.println("doGet");
		doTask(request,response);
	}

	private void doTask(HttpServletRequest request,HttpServletResponse response){
		Enumeration<String> headers=request.getHeaderNames();
		while(headers.hasMoreElements()){
			String header=headers.nextElement();
		    System.out.println(header+":"+request.getHeader(header));
		}
		
		try{
			response.setContentType("charset=Utf-8");
			PrintWriter  out=response.getWriter();
			out.write("雲羅公主，我愛你愛了五百年");
			out.flush();
			out.close();
		}
		catch(Exception e){
			e.toString();
		}
	}
}
