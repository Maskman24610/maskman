<%@page import="java.util.LinkedList"%>
<%@page import="java.util.HashMap"%>
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
		String[] names={"許用","明瑩","Mars"};
		request.setAttribute("urname",names);
	%>
	Name 1:${urname[0]}<br>
	Name 2:${urname[1]}<br>
	Name 3:${urname[2]}<br> 
	<hr>
	<%
		HashMap<String,String> data=new HashMap<>();
	    data.put("my name","林明瑩");
	    data.put("passwd.1","1226");
	    data.put("gender","female");
	    request.setAttribute("data",data);
	%>
	User:${data["my name"] }<br>
	Password:${data["passwd.1"] }<br>
	Gender:${data["gender"]}<br>
	<hr>
	<%
		LinkedList<String> list=new LinkedList<>();
		list.add("aaaa");
		list.add("許用");
		list.add("明瑩我喜歡妳");
		request.setAttribute("list",list);
	%>
	List: ${list[param.i]}
</body>
</html>