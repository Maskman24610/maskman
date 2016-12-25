<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<sql:setDataSource driver="com.mysql.jdbc.Driver" 
	url="jdbc:mysql://localhost/iii" user="root" password="root" 
	/> 
<sql:transaction isolation='serializable'>
	<sql:update var="n"
	sql="delete from member where id > ?">
	<sql:param value="22" />
</sql:update>
<sql:update var="n"
	sql="update member set account=?,passwd=? where id = 14">
	<sql:param value="brad" />
	<sql:param value="123" />
</sql:update>
	
</sql:transaction>

<sql:query var="result">
select * from member
</sql:query>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
active: ${n }<br>
MySQL: Total: ${result.rowCount }
<hr>
<c:forEach items="${result.rows}" var="member">
${member.id }:${member.account }:${member.passwd }:${member.realname }<br>
</c:forEach>
</body>
</html>