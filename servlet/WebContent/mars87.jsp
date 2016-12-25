<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix='sql' uri="http://java.sun.com/jsp/jstl/sql" %>

<sql:setDataSource driver='com.mysql.jdbc.Driver' user='root' password='root' url='jdbc:mysql://localhost/iii?characterEncoding=Utf-8'  var='iii' scope='page'/>

<sql:query var='result' sql='select * from member' dataSource='${iii}'/>

<sql:transaction dataSource='${iii }'>
	<sql:update  var='n' sql="insert into member (account,passwd,realname) values (?,?,?)">
	 <sql:param value='${param.account} '/>
	 <sql:param value='${param.passwd} '/>
	 <sql:param value='${param.realname} '/>
</sql:update>
<sql:query var="lastid" >
	select last_insert_id() as newid
</sql:query>
</sql:transaction>

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
	<c:if test='${n>=1 }'>
		Last ID: ${lastid.rows[0].newid }
	</c:if>
	MySQL:Total:${result.rowCount}
	<hr>
	
	<c:forEach items='${result.rows}' var='member'>			
		${member.id}:${member.account}:${member.realname}:${member.passwd}<br> 
	</c:forEach>
</body>
</html>