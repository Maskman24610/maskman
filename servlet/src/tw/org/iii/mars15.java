package tw.org.iii;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class mars15
 */
@WebServlet("/mars15")
public class mars15 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PrintWriter out;   
	private Connection conn;
	private String[]fields={"id","account","passwd","realname"};
	/**
     * @see HttpServlet#HttpServlet()
     */
    public mars15() {
        super();
        // TODO Auto-generated constructor stub
    }
   
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	try{
 		   Class.forName("com.mysql.jdbc.Driver");
 		   Properties prop=new Properties();
 		   prop.setProperty("user", "root");
 		   prop.setProperty("password", "root");
 		   conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1/iii",prop);
 	       System.out.println("OK");
 	   }
 	   catch(Exception e){
 		   System.out.println("Exception happen");
 	   }
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
	  
	  String type=request.getParameter("type");
	  String delid=request.getParameter("delid");
	  if(type!=null&& type.equals("add")){
		  //insert
		  String account=request.getParameter("account");
		  String passwd=request.getParameter("passwd");
		  String realname=request.getParameter("realname");
		  addData(account,passwd,realname);
	  }
	  else if(delid!=null){
		  delData(delid);
	  }
	  else if(type!=null&&type.equals("edit")){
		  String updateid=request.getParameter("updateid");
		  String account=request.getParameter("account");
		  String passwd=request.getParameter("passwd");
		  String realname=request.getParameter("realname");
		  editData(updateid,account,passwd,realname);
	  }
	  outHtml(queryData());
	}
   private void addData(String account,String passwd,String realname){
	   try{
		   PreparedStatement pstmt=conn.prepareStatement(
				   "Insert into member(account,passwd,realname) "+
		   "values(?,?,?)");
		   pstmt.setString(1, account);
		   pstmt.setString(2,passwd);
		   pstmt.setString(3,realname);
		   pstmt.execute();
	   }
	   catch(Exception e){
		   System.out.println(e.toString());
	   }
   }
   
   private void delData(String id){
	   try{
		   PreparedStatement pstmt=conn.prepareStatement(
				   "delete from member where id=?");
		   pstmt.setString(1, id);
		   pstmt.execute();
	   }
	   catch(SQLException e){
		   System.out.println(e.toString());
	   }
   }
   
   private void editData(String updateid,String account,String passwd,String realname){
	   try{
		   PreparedStatement pstmt=conn.prepareStatement(
				   "update member set account=?,passwd=?, realname=? where id=?");
		   pstmt.setString(1, account);
		   pstmt.setString(2,passwd);
		   pstmt.setString(3,realname);
		   pstmt.setString(4, updateid);
		   pstmt.execute();
	   }
	   catch(Exception e){
		   System.out.println(e.toString());
	   }
   }
   
   
	private ArrayList<HashMap<String,String>> queryData(){
		   ArrayList<HashMap<String,String>> data=new ArrayList<>();
		   try{
			   PreparedStatement pstmt=conn.prepareStatement("select * from member");
			   ResultSet rs=pstmt.executeQuery();
			   while(rs.next()){
				   HashMap<String,String> row=new HashMap();
				   for(String field:fields){
					   row.put(field, rs.getString(field));
				   }
				   data.add(row);
			   }
		   }
		   catch(Exception e){
			   System.out.println(e.toString());
		   }
		   return data;
	   }
	
   private void outHtml(ArrayList<HashMap<String,String>> data){
       out.println("<script>function isDelete(name){return confirm('Delete '+name+' ?');}</script>");
	   out.println("<h1>Mars Big Company</h1><hr>");
	   out.println("<a href='mars16.html'>AddNew</a>");
	   out.print("<table border='1' width='100%'>");
	   out.print("<tr>");
	   out.print("<th> Id.</th>");
	   out.print("<th> Account</th>");
	   out.print("<th> Password</th>");
	   out.print("<th> Realname</th>");
	   out.print("<th> Delete</th>");
	   out.print("<th>Edit</th>");
	   out.print("</tr>");
	   for(HashMap<String,String> row:data){
		   out.print("<tr>");
		   for(String field:fields){
		   out.println(String.format("<td> %s",row.get(field)));
		   }
		   out.print(String.format("<td><a href=?delid=%s onclick='return isDelete(\"%s\")'>Delete</a></td>"
				   ,row.get(fields[0]),row.get(fields[1])));
		   out.print(String.format("<td><a href='mars16?editid=%s'>Edit</a></td>",row.get(fields[0])));
		   out.print("</tr>");
	   }
	   out.println("</table>");
   }
   
   
}
