package tw.org.iii;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hello
 */
@WebServlet("/Hello")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hello() {
        super();
        System.out.println("Hello()");
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init() throws ServletException{
    	super.init();
    	System.out.println("init()");
    }
   @Override
   public void service(ServletRequest request,ServletResponse response) throws ServletException,IOException{
	  System.out.println("service()");
	  try{
		  HttpServletRequest req=(HttpServletRequest)request;
//		  String method=;
		  
	  }
	  catch(ClassCastException ce){
		  System.out.println(ce.toString());
	  }
	  
	  Enumeration<String> ps=request.getParameterNames();
	  while(ps.hasMoreElements()){
		  String item=ps.nextElement();
		  String value=request.getParameter(item);
		  System.out.println(item+"="+value);
	  }
   }
	/**ri
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet()");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	   //doGet(request, response);
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost()");
		//doGet(request, response);
	}

}
