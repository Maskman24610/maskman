<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:directive.page import='tw.mars.j2ee.member' />
<%
		member member=new member();
       member.setId("003");
       member.setName("Mars");
%>

<%! int j; %>

<jsp:declaration>
	int i;
	int k;
	String name;
</jsp:declaration>
<jsp:scriptlet>
	k++;
	name="明瑩";
</jsp:scriptlet>

<jsp:expression>
	name
</jsp:expression>
<jsp:text>
	,我喜歡妳
</jsp:text>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>

<body>
	Welcome, <%=member.getName() %><br>
<%=i++ %><br>
<%=j++ %><br>
<%=k %>
</body>
</html>