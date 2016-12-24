<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Import 範例</title>
</head>

<body>
	Header
	<hr>
	<c:import url="import.txt" var='import2'></c:import>
	<jsp:include page="import.txt"/>
	<hr>
	${import2}
	<hr>
	<c:import url='mars78.jsp?x=225&y=125'>
		<c:param name="x" value='15'></c:param>
		<c:param name="y" value='225'></c:param>
	</c:import>
	<hr>
	<c:url value="http://www.iii.org.tw"/>
	<hr>
	<c:import url='http://www.iii.org.tw'></c:import>
	<hr>
	Footer
</body>
</html>