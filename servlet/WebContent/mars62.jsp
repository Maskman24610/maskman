<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <jsp:useBean id='Member' class="tw.mars.j2ee.member" />
 <jsp:setProperty name='Member' property='id' value='${param.id}' />
 <jsp:setProperty name='Member' property='name' value='${param.name}' />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>JavaBean</title>
</head>

<body>
	Welcome,
	<jsp:getProperty name="Member" property='id' />
	<hr>
	<jsp:getProperty name='Member' property='name' />
	<hr>
	Welcom,
	${Member["name"]}
</body>
</html>