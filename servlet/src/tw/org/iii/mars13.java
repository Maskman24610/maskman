package tw.org.iii;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class mars13
 */
@WebServlet("/mars13")
public class mars13 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mars13() {
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
	  PrintWriter out=response.getWriter();
	  
	  String x=(String) request.getAttribute("x");
	  String y=(String) request.getAttribute("y");
	  String res=(String) request.getAttribute("res");
	  //load mars07.html
	  String htmlString=loadView("mars07.html");
	  htmlString=String.format(htmlString,x,y,res);
	  out.print(htmlString);
	}
    
	private String loadView(String file){
		String uploadPath=getServletContext().getInitParameter("upload-path");
		File uploadFile=new File(uploadPath,file);
		
		long len=uploadFile.length();
		byte[] buf=new byte[(int)len];
		
		try{
			BufferedInputStream bin=new BufferedInputStream(new FileInputStream(uploadFile));
			bin.read(buf);
			bin.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return new String(buf);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
