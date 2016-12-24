<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>

<body>
	<fmt:setBundle basename='mesg_en' var='en' />
	<fmt:setBundle basename='mesg_zh_TW' var='tw' />
	<fmt:message key='hello' bundle='${en}' />,
	<fmt:message key='who' bundle='${tw }'/>
</body>
</html>