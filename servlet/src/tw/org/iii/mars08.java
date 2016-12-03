package tw.org.iii;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class mars08
 */
@MultipartConfig(location="C:/Users/Joseph/git/maskman/servlet/WebContent/upload3")
@WebServlet("/mars08")
public class mars08 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mars08() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("Utf-8");
		response.setCharacterEncoding("Utf-8");
		PrintWriter out = response.getWriter();
		
		Collection<Part> parts=request.getParts();
		for(Part part:parts){
		// must be @MultipartConfig => Tomcat
	    //part = request.getPart("upload");
		
			String header = part.getHeader("Content-Disposition"); //Content-Disposition
			
			String myfilename = getFilename(header);
			long size=part.getSize();
			
			out.print(myfilename+":"+size+"<br />");
			if(size>0){
				part.write(myfilename);
			}
		}
	}

	
	private String getFilename(String body){
		int start = body.indexOf("filename=\"");
		String temp = body.substring(start+10);
		String filename = temp.substring(0, temp.indexOf("\""));
		int s = filename.lastIndexOf("\\");
		filename = filename.substring(s+1);
		
		return filename;
	}
}
