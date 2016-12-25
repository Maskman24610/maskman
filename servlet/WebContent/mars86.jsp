<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix='sql' uri="http://java.sun.com/jsp/jstl/sql" %>

<sql:setDataSource dataSource='jdbc:sqlserver://localhost:1433;databaseName=LabDB,com.microsoft.sqlserver.jdbc.SQLServerDriver,sa,sa' var='labdb'/>
<sql:setDataSource driver='com.mysql.jdbc.Driver' user='root' password='root' url='jdbc:mysql://localhost/iii'  var='iii' scope='session'/>

<sql:query var='result1' sql='select * from member' dataSource='${iii}'/>
<sql:query var='result2' sql='select * from LabTable' dataSource='${labdb }'/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>

<body>
	<!--  ${result} ==>Object
	1.rowCount
	-->
	MySQL:Total:${result1.rowCount}
	<hr>
	MSSQL:Total:${result2.rowCount}
	<hr>
	<c:forEach items='${result1.rows}' var='member'>			
		${member.id}:${member.account}:${member.realname}:${member.passwd}<br> 
	</c:forEach>
</body>
</html>