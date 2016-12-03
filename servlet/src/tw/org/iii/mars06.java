package tw.org.iii;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class mars06
 */
@MultipartConfig
@WebServlet("/mars06")
public class mars06 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mars06() {
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
	   
	   Part part=request.getPart("upload");
	   String header=part.getHeader("Content-Disposition");
	   out.print(header+"<br/>");
	   
	   String filename=part.getSubmittedFileName();
	   
	   String type=part.getContentType();
	   String name=part.getName();
	   long len=part.getSize();
	   String myfilename = getFilename(header);
	   out.println(type+":"+name+":"+len+myfilename);
	   
	   
	   byte[] buf=new byte[(int) len];
	   BufferedInputStream  bin=new BufferedInputStream(part.getInputStream());
	   bin.read(buf);
	   bin.close();
	   
       ServletContext context=getServletContext();
       String uploadPath=context.getInitParameter("upload-path");
       out.println(uploadPath);
       
       FileOutputStream fout=new FileOutputStream(new File(uploadPath,"mars.png"));
       fout.write(buf);
       fout.flush();
       fout.close();
//	   ServletContext context = getServletContext();
//		String uploadPath = context.getInitParameter("upload-path");
//		out.println(uploadPath);
//		
//		FileOutputStream fout = new FileOutputStream(new File(uploadPath, "brad.png"));
//		fout.write(buf);
//		fout.flush();
//		fout.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
    private String getFilename(String body){
    	int start=body.indexOf("filename=\"");
    	String temp=body.substring(start+10);
    	String filename=temp.substring(0,temp.indexOf("\'"));
    	int s=filename.lastIndexOf("\\");
    	filename=filename.substring(s+1);
    	
    	return filename;
    }
//	private String getFilename(String body){
//		int start = body.indexOf("filename=\"");
//		String temp = body.substring(start+10);
//		String filename = temp.substring(0, temp.indexOf("\""));
//		int s = filename.lastIndexOf("\\");
//		filename = filename.substring(s+1);
//		
//		return filename;
//	}	
	
}
