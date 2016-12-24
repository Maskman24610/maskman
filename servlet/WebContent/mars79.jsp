<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>轉向</title>
</head>
<body>
	<c:catch>
		<c:redirect url='mars80.jsp' >	
			<c:param name='key' value='val'>
			</c:param>
		</c:redirect>
	</c:catch>
</body>
</html>