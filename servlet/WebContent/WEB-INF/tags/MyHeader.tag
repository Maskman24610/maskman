<%@ tag description='首頁' pageEncoding='Utf-8'%>
<%@taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name='pageName' %>
<%@ attribute name='func' %>
<%@attribute name='url' %>
<%@attribute name='year' %>
<h1>Mars </h1>
	<hr>
	${pageName}:<a href='${url}'>${func }</a> 
	<hr>
	<jsp:doBody />
	<hr>
	Copyright ${year}