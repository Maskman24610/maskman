package tw.org.iii;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class mars05
 */
@WebServlet("/mars05")
public class mars05 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mars05() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	   response.setContentType("text/html; charset=utf-8");
	   request.setCharacterEncoding("utf-8");
	   response.setCharacterEncoding("UTF-8");
	   PrintWriter pw=response.getWriter();
	   
	   String type=request.getContentType();
	   int len=request.getContentLength();
	   pw.print(type+":"+len);
	   
//	   BufferedReader reader=request.getReader();
//	   String line;
//	   int i=1;
//	   while((line=reader.readLine())!=null){
//		   pw.print(i++ +">"+line+"<br />");
//	   }
//	   reader.close();
	   
	   
	   InputStream in=request.getInputStream();
	   byte[] buf=new byte[len];
	   in.read(buf);
	   in.close();
	   
	   String cont=new String(buf);
	   pw.print(cont);
       
//	   private String getFilename(String body){
//		   int start=
//	   };
//	   private String getFilename(String body){
//			int start = body.indexOf("filename=\"");
//			String temp = body.substring(start+10);
//			String filename = temp.substring(0, temp.indexOf("\""));
//			return filename;
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
