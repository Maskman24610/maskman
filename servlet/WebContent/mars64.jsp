<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String x=request.getParameter("x");
    String y=request.getParameter("y");
    int r=Integer.parseInt(x)+Integer.parseInt(y);
%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>

<body>
	<%=x %>
	+
	<%=y %>
	=
	<%=r %>
</body>
</html>