package tw.org.iii;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class mars16
 */
@WebServlet("/mars16")
public class mars16 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn=null;
	private PrintWriter out;
	private String[] fields={"id","account","passwd","realname"};
	
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	try{
    		Class.forName("com.mysql.jdbc.Driver");
    		Properties prop=new Properties();
    		prop.setProperty("user","root");
    		prop.setProperty("password","root");
    		conn=DriverManager.getConnection("jdbc:mysql://localhost/iii",prop);
    	}
    	catch(Exception e){
    		System.out.println(e.toString());
    	}
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
       //response.getWriter().append("Served at: ").append(request.getContextPath());
	   response.setContentType("text/html;charset=Utf-8");
	   request.setCharacterEncoding("Utf-8");
	   response.setCharacterEncoding("Utf-8");
		  
	   out=response.getWriter();
	   
	   String editid=request.getParameter("editid");
	   //query editid
	   //output
	   outHtml(queryData(editid));
	}
	
	private HashMap<String,String>queryData(String id){
		HashMap<String,String>row=new HashMap<>();
		try{
			PreparedStatement pstmt=conn.prepareStatement("Select * from member"+
		" where id=?");
			pstmt.setString(1,id);
			ResultSet rs=pstmt.executeQuery();
			rs.first();
			for(String field:fields){
				row.put(field,rs.getString(field));
			}
		}
		catch(SQLException e){
			System.out.println(e.toString());
		}
		
		return row;
	}

   private void outHtml(HashMap<String,String> row){
	   out.println("<meta http-equiv='Content-Type' content='text/html;charset=utf-8'>");
	   out.println("<form action='mars15'>");
	   out.println(String.format("<input type='hidden' name='updateid' value='%s'><br>",row.get("id") ));
       out.println(String.format("Account:<input type='text' name='account' value='%s'><br>",row.get("account")));
       out.println(String.format("Password:<input type='password' name='passwd' value='%s'><br>",row.get("passwd")));
       out.println(String.format("RealName:<input type='text' name='realname' value='%s'><br>",row.get("realname")));
       out.println("<input type='submit' name='type' value='edit'>");
       out.println("</form>");
   }
}
