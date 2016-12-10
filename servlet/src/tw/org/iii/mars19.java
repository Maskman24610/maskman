package tw.org.iii;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class mars19
 */
@WebServlet("/mars19")
public class mars19 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Connection conn;
    private PrintWriter out;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mars19() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	try{
    		Class.forName("com.mysql.jdbc.Driver");
    		Properties prop = new Properties();
			prop.setProperty("user", "root");
			prop.setProperty("password", "root");
			conn = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1/iii?&setCharcater=Utf-8", prop);
			Statement stmt = conn.createStatement();
			stmt.execute("SET NAME UTF8");
			System.out.println("connection Ok");
    	}
    	catch(Exception e){}
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
		response.setContentType("text/html;charset=utf-8");
		out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		//response.setCharacterEncoding("Utf-8");
		
		String account= request.getParameter("account"); 
		String passwd = request.getParameter("passwd"); 
        
		try{
			PreparedStatement pstmt=
					conn.prepareStatement("Select * from member where account = ?");
		   pstmt.setString(1, account);
		   ResultSet rs=pstmt.executeQuery();
		   if(rs.first()){
			   	String passwdHash=rs.getString("passwd");
			   	if(MarsUtils.checkPassword(passwd,passwdHash)){
			   		out.print("OK");
			   	}
			   	else{
			   		out.println("Password Failed");
			   	}
		   }
		   else{
			   out.println("Account not exist");
		   }
		}
		catch(Exception e){
			System.out.println(e.toString());
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
