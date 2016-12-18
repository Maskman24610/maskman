<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test='${ param.name=="明瑩"}' var='test1'>
		明瑩，我喜歡妳<br>
	</c:if>
	<c:if test='${parse.name==null}'>
	    請輸入name<br>
	</c:if>
	<c:if test="${3<4 }" var='test2'/>
		test is true<br>
		<c:if test='${test1 and test2 }'>
			OK		
		</c:if>
	
</body>
</html>