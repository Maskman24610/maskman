package tw.org.iii;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class mars21
 */
@WebServlet("/mars21")
public class mars21 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mars21() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	   response.setContentType("image/jpeg");
	   
	   String strRate=request.getParameter("rate");
	   float rate=Float.parseFloat(strRate);

	   //Canvas=>40X20
	   BufferedImage bimg=new BufferedImage(400,20,BufferedImage.TYPE_INT_RGB);
	   Graphics2D g2d=bimg.createGraphics();
	   //make pic
	   g2d.setColor(Color.yellow);
	   g2d.fillRect(0,0,400,20);
	   g2d.setColor(Color.blue);
	   g2d.fillRect(0,0,(int)(400*rate/100),20);
	   //輸出
	   OutputStream ops=response.getOutputStream();
	   ImageIO.write(bimg, "jpeg", ops);
	   ops.flush();
	   ops.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
