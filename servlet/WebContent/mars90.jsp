<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<sql:setDataSource driver="com.mysql.jdbc.Driver" 
	url="jdbc:mysql://localhost/iii" user="root" password="root" 
	var="iii" scope="page"/> 

<sql:transaction dataSource="${iii }">
	<sql:update var="n"
		sql="insert into mydog (lat,lng) values (?,?)">
		<sql:param value="${param.lat }" />
		<sql:param value="${param.lng }" />
	</sql:update>
</sql:transaction>