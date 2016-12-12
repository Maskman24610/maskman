<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@  page import='java.util.*' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>第一支JSP範例</title>
</head>


<body>
<% int a=0; %>         
<%! int b=0; %>  <!--   static  var-->
	<%
		int lottery=(int)(Math.random()*49+1);
	    out.print(lottery);
	%>
	<hr>
	<%=Calendar.getInstance().get(Calendar.YEAR) %>
	<hr />
	a=<%= a++ %><br />
	b=<%=b++  %>
</body>
</html>