<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import='java.sql.*' %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//jsp
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connectionUrl = 
					"jdbc:sqlserver://localhost;" + "databaseName=LabDB;user=sa;password=sa;";
		    Connection conn=DriverManager.getConnection(connectionUrl);
		   // Statement stmt=conn.createStatement();
		    //stmt.execute("insert into member(account,passwd,realname) values ('mars','12345','mars')");
		    System.out.print("OK");
		}
		catch(Exception e){
			System.out.println(e.toString());
		}
	%>
</body>
</html>