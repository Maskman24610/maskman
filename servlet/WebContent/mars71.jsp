<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id='Member' class="tw.mars.j2ee.member" />
 <jsp:setProperty name='Member' property='id' value='${param.id}' />
 <jsp:setProperty name='Member' property='name' value='${param.name}' />
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>

<body>
	<c:set var='x' value='11' scope='page'></c:set>  <!-- scope 預設為page -->
	<%//pageContext.setAttribute("x","11") %>
	<c:set var='x'  scope='request'>12</c:set>
	<c:set var='x' value='13' scope='session'></c:set>
	<hr>
	
	<c:set var='x' value='14' scope='application'></c:set>
	Session:<c:out value='${sessionScope.x}'></c:out><br />
	Request:<c:out value='${requestScope.x}' ></c:out><br />
	<hr>
	<c:out value='${Member.name }' />
	<hr>
	<c:set target='${Member }' property='name' value='明瑩'></c:set>
	${Member.name }
	<hr>
	<c:remove var="x" scope='session'/>
	Session:<c:out value='${sessionScope.x }' default='no-value'/><br>
	<hr>
	${Member} 
</body>
</html>