package tw.org.iii;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class mars26
 */
@WebServlet("/mars26")
public class mars26 extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private PrintWriter out;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mars26() {
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
	   
	// Check Cookie First
	   Cookie[] cookies=request.getCookies();
	   if(cookies!=null){
		   HashMap<String,String> mapCookies=new HashMap<>();
		   for(Cookie cookie:cookies){
			   String name=cookie.getName();
			   String value=cookie.getValue();
			   mapCookies.put(name, value);
		   }
		   if(mapCookies.containsKey("account")&&mapCookies.containsKey("passwd")){
			   String account=mapCookies.get("account");
			   String passwd=mapCookies.get("passwd");
			   if(account.equals("mars")&&passwd.equals("235813")){
				   request.getRequestDispatcher("test02").forward(request, response);
				   return;
			   }
		   }
	   }
	   
	   String account=request.getParameter("account");
	   String passwd=request.getParameter("passwd");
	   if(account!=null){
		   String auto=request.getParameter("auto");
		 //check account /password
		   if(account.equals("mars")&&passwd.equals("235813")){
			   //Login OK
			   if(auto!=null&&auto.equals("true")){
				   //addCookie
                  Cookie accountCookie=new Cookie("account",account);
                  accountCookie.setMaxAge(7*24*60*60);
                  
                  Cookie passwdCookie=new Cookie("passwd",passwd);
                  passwdCookie.setMaxAge(7*24*60*60);
                  
                  response.addCookie(accountCookie);
                  response.addCookie(passwdCookie);
			   }
			   //forward
			   request.getRequestDispatcher("test02").forward(request, response);
		   }
	   }
	   
	   outHtml();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
   private void outHtml(){
	   out.println("<meat charset='utf8'>");
	   out.println("<head>");
	   out.println("<title>Cookie範例</title>");
	   out.println("</head>");
	   out.println("<body>");
	   out.println("<form action='mars26' >");
	   out.println("帳號:<input type='text' name='account'><br />");
	   out.println("密碼:<input type='password' name='passwd'><br />");
	   out.println("<input type='checkbox' name='auto' value='true'>Auto<br />");
	   out.println(	"<input type='submit' value='登入'>");	
	   out.println("</form>");
	   out.println("</body>");
   }
}
