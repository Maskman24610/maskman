<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>

<body>
	<%
		String method=((HttpServletRequest)pageContext.getRequest()).getMethod();
	    String query=((HttpServletRequest)pageContext.getRequest()).getQueryString();
	    String ip=((HttpServletRequest)pageContext.getRequest()).getRemoteAddr();
	%>
	Method=<%=method %>;<br>
	Query=<%=query %>;<br>
	IP:<%=ip %>;<br>
	<hr>
	Method:${pageContext.request.method}
</body>
</html>