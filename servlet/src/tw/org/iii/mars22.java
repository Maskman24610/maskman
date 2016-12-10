package tw.org.iii;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class mars22
 */
@WebServlet("/mars22")
public class mars22 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/jpeg");
		
		String imgPath=getServletContext().getInitParameter("imgs-path");
		File imgBg=new File(imgPath,"mingying.jpg");
		//Canvas
		BufferedImage bimg=ImageIO.read(imgBg);
		Graphics2D g2d=bimg.createGraphics();
		
		//drawing...
		Font font=new Font(null,Font.BOLD+Font.ITALIC,36);
		
		AffineTransform tran=new AffineTransform();
		
		tran.rotate(Math.toRadians(30),100,0);
		
		Font newfont=font.deriveFont(tran);
		
		g2d.setFont(newfont);
		g2d.setColor(Color.black);
		g2d.drawString("明瑩，我喜歡妳!",100,100);
		
		g2d.setFont(font);
		g2d.setColor(Color.red);
		g2d.drawString("明瑩，我喜歡妳!",100,100);
		//Output
		OutputStream ops=response.getOutputStream();
		ImageIO.write(bimg, "jpeg", ops);
		ops.flush();
		ops.close();
		
	}


}
