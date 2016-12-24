<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var='num' value='1234567.89'/>
	<fmt:setLocale value='zh'/>
	<fmt:formatNumber value='${num}'/><br>
	<fmt:formatNumber value='${num}' minIntegerDigits='11'/><br>
	<fmt:formatNumber value='${num }' type='currency' currencyCode='TWD'/>
	<hr>
	<fmt:setLocale value='fr'/>
	<fmt:formatNumber value='${num}' type='currency'/>
	<hr>
	<fmt:setLocale value='de'/>
	<fmt:formatNumber value='${num}'/>
	<hr>
	<fmt:parseNunber value=' 56,789.321' var='price'/>
	${price}
</body>
</html>