<%@tag description='' pageEncoding='Utf-8'%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!-- 接受參數 -->
<%@attribute name='x' required='true'%>
<%@attribute name='y' required='true'%>

<!-- 計算結果 -->
<%@variable name-given='addResult' %>
<%@variable name-given='subResult' %>
<%@variable name-given='multiplyResult' %>
<%@variable name-given='divideResult' %>

<c:set var='addResult' value='${x+y}' />
<c:set var='subResult' value='${x-y}' />
<c:set var='multiplyResult' value='${x*y}' />
<c:set var='divideResult' value='${x/y}' />

<jsp:doBody />