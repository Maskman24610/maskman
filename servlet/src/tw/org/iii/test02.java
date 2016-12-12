package tw.org.iii;

import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;

//import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class test02
 */
@WebServlet("/test02")
public class test02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public test02() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
//    protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
//    	// TODO Auto-generated method stub
//    	super.service(arg0, arg1);
//    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	    try{
	    	//取得Session
	    	HttpSession hs=request.getSession(true);              //取得Session
	    	Integer cn=(Integer) hs.getAttribute("count");        //取得設定再Session的值
	    	Date dt=(Date) hs.getAttribute("date");
	    	
	    	String str1,str2;
	    	
	    	//設定次數
	    	if(cn==null){
	    		cn=new Integer(1);
	    		dt=new Date();
	    		str1="這是您的第一次造訪";
	    		str2="";
	    	}
	    	else{
	    		cn=new Integer(cn.intValue()+1);
	    		dt=new Date();
	    		str1="這是您的第"+cn+"次造訪";
	    		str2="(上次是在:"+dt+")";
	    	}
	    	//設定Session
	    	hs.setAttribute("count",cn);                    //在Session中設定名稱與值
	    	hs.setAttribute("date",dt);
	    	
	    	//設定內容類型
	    	response.setContentType("text/html; charset=Utf-8");
	    	
	    	//輸出Html文件
	    	PrintWriter pw=response.getWriter();
	    	pw.println("<html>\n"+
	    	                    "<head><title>Session範例</title></head>\n"+
	    			            "<body><center>\n"+
	    			            "<h2>歡迎光臨</h2>\n"+
	    			            "<hr />\n"+
	    			            str1+"<br />\n"+
	    			            str2+"<br />\n"+
	    			            "請選擇一件商品。<br />\n"+
	    			            "<a href=\"../car1.html\">汽車</a><br />\n"+
	    			            "<a href=\"../car2.html\">卡車</a><br />\n"+
	    			            "<a href=\"../car3.html\">戰車</a><br />\n"+
	    			            "</center></body>\n"+
	    			            "</html>\n");
	    }
	    catch(Exception e){
	    	e.printStackTrace();
	    }
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
