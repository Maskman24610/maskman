<%@page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri='http://www.iii.org.tw/mars/tags' prefix='mytag' %>
<%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>

<body>
	<mytag:if test="${param.name=='mars'}">
		doTag():Hello, Mars. 林明瑩我喜歡妳!!!
	</mytag:if>
	<hr>
	<% 
		LinkedList<String> names=new LinkedList<String>();
		names.add("許用");
		names.add("OK");
		names.add("明瑩我喜歡妳");
		pageContext.setAttribute("names",names);
	%>
	<mytag:loop var='name' items='${names}'>
		 Hello ,${name}<br> 
	</mytag:loop>
</body>
</html>