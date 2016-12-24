<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import='java.util.*' %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>i18n taglib 多國語系範例</title>
</head>

<body>	
	<%
		Date now=new Date();
		pageContext.setAttribute("now", now);
	%>
	
	<fmt:requestEncoding value='Utf-8'/>
	<fmt:setLocale value="zh"/>           <!-- 語系地區 =>iso639-->
	<fmt:formatDate value='${now}' /><br>
	<fmt:setLocale value="en"/>
	<fmt:formatDate value='${now}' /><br>
	<fmt:setLocale value="ja"/>
	<fmt:formatDate value='${now}' /><br>
	<fmt:setLocale value="na"/>
	<fmt:formatDate value='${now}' /><br>
</body>
</html>