<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix='sql' uri="http://java.sun.com/jsp/jstl/sql" %>

<sql:setDataSource driver='com.mysql.jdbc.Driver'
 user='root' password='root' url='jdbc:mysql://localhost/iii?characterEncoding=Utf-8' 
 var='iii' scope='page'/>
 
 <sql:query var='result' dataSource="${iii}">
 	select * from mydog where id=${param.id} 
 </sql:query>
 <c:forEach items='${result.rows }' var='pos'>
 	${pos.lat}:${pos.lng}<br> 
 </c:forEach>
