<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>

<body>
	<%
		//csv=>real line
		String str= "1,Mingying,female,0939-909920,1988-12-26,台中市西屯區";
		String str2= "2:許用:男:0930-743877:1989-06-07:台中市太平區";
		pageContext.setAttribute("str",str);
		pageContext.setAttribute("str2",str2);
	%>
	<c:forTokens items="${str}" delims="," var="field"
	begin="2" end="4" step='1'>
		${field}<br>
	</c:forTokens>
	<c:forTokens items="${str2}" delims=":" var="field"
	>
		${field}<br>
	</c:forTokens>
</body>
</html>