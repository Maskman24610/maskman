<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib tagdir='/WEB-INF/tags' prefix='mars' %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix='fn'%>
<%@taglib uri="http://www.iii.org.tw/mars/tags" prefix='mytag' %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<mars:MyCal x='100' y='33'>
		10+3=${addResult}<br>
		10-3=${subResult}<br>
		10*3=${multiplyResult}<br>
		10/3=${divideResult}<br>
	</mars:MyCal>
	<hr>
	<mars:MyData title='' name='mars' gender='male' age='28'>
	</mars:MyData>
<!--  <c:set var='account' value='marsshoong' />
	<hr>
	<c:if test="${fn:contains(accoun')}">
		${fn: length(account) }
	</c:if>-->
	<hr>
	<c:set var="account" value="bradchao" />
<c:if test="${fn:contains(account, 'brad') }">
${fn:length(account) }
</c:if>
<hr />
<mytag:MyCal x="100" y="33">
	10 + 3 = ${addResult }<br />
	10 + 3 = ${subResult }<br />
	10 + 3 = ${multiplyResult }<br />
	10 + 3 = ${divideResult }<br />
</mytag:MyCal>
	${mytag:sayHello("林明瑩")} 
</body>
</html>