package tw.org.iii;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

//練習如何將密碼加密
/**
 * Servlet implementation class mars18
 */
@WebServlet("/mars18")
public class mars18 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PrintWriter out;
	private static int workload=12;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mars18() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	   response.setContentType("text/html;charset=utf-8");
	   request.setCharacterEncoding("Utf-8");
	   response.setCharacterEncoding("Utf-8");
	   
	   out=response.getWriter();
	   
	   String pass1="123456";
	   String pass2=hashPassword(pass1);
	   out.print(pass1+"=>"+pass2+"<br />");
	   
	   String pass3=hashPassword(pass1);
	   out.print(pass1+"=>"+pass3+"<br>");
	   
	   if(checkPassword("12345",pass2)){
		   out.println("OL");
	   }
	   else{
		   out.println("XX");
	   }
	}

	private String hashPassword(String password_plaintext){
			String salt=BCrypt.gensalt(workload);
			String hashed_password=BCrypt.hashpw(password_plaintext,salt);
			
			return (hashed_password);
	}
    
	public static boolean checkPassword(String password_plaintext,String stored_hash){
		   boolean password_verified=false;
		   
		   if(null==stored_hash || !stored_hash.startsWith("$2a$"))
			   throw new java.lang.IllegalArgumentException("Invalid hash provided for  comparison");
		   password_verified=BCrypt.checkpw(password_plaintext,stored_hash);
		   
		   return (password_verified);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
