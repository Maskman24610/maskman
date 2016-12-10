package tw.org.iii;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Servlet implementation class mars20
 */
@WebServlet("/mars20")
public class mars20 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private Connection conn;
       private PrintWriter out;
    public mars20() {
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
					"jdbc:mysql://127.0.0.1/ii?characterEncoding=Utf-8", prop);
			Statement stmt = conn.createStatement();
			stmt.execute("SET NAMES utf8");
    	}
    	catch(Exception e){
    		System.out.println(e.toString());
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
		
		out=response.getWriter();
		
		String jsonString=getJSONString(
				"http://data.coa.gov.tw/Service/OpenData/ODwsv/ODwsvTravelFood.aspx");
		if(jsonString!=null){
			out.println(jsonString);
			parseJSON(jsonString);
		}
		
	}
	//取得Open data 的 Json資料
	private String getJSONString(String url){
		String ret=null;
		try{
			URL jsonURL=new URL(url);
			HttpURLConnection conn= (HttpURLConnection) jsonURL.openConnection();
		    conn.connect();
		    
		    BufferedReader  reader=new BufferedReader(new InputStreamReader(conn.getInputStream(),"Utf8"));
	        ret=reader.readLine();
	        //System.out.println(ret);
	        reader.close();
		}
		catch(Exception e){
			System.out.println(e.toString());
		}
		
		return ret;
	}

	private void parseJSON(String json){
		try{
			PreparedStatement pstmt=conn.prepareStatement(
					"insert into food (name,addar,tel)"+" values (?,?,?)");
			JSONArray root=new JSONArray(json);
		//System.out.println(root.length());
		   for(int i=0;i<root.length();i++){
		       JSONObject row=   root.getJSONObject(i);
		       String name=row.getString("Name");
		       String addar=row.getString("Address");
		       String tel=row.getString("Tel");
		       out.print(name+ ":"+tel+"<br />");
		       
		       pstmt.setString(1, name);
		       pstmt.setString(2, addar);
		       pstmt.setString(3,tel);
		       pstmt.execute();
		   }   
		}
		catch(Exception e){
			System.out.println(e.toString());
		}
	}
//	private void addData(String account,String passwd,String realname){
//		try {
//			PreparedStatement pstmt = 
//					conn.prepareStatement(
//							"insert into member (account,passwd,realname) " +
//							"values (?,?,?)");
//			pstmt.setString(1, account);
//			pstmt.setString(2, passwd);
//			pstmt.setString(3, realname);
//			pstmt.execute();
//		} catch (SQLException e) {
//			System.out.println(e.toString());
//		}
//	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
