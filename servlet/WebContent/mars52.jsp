<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>九九乘法表</title>
</head>


<body>
<table border='1' width='100%'>
		
			<%
			    for(int k=0;k<4;k++){
				    out.print("<tr>");
					for(int j=2;j<=5;j++){
						int newj=j+k*4;
						if((j+k)%2==0){
					    	out.print("<td bgcolor='blue'>");
						}
						else{
							out.print("<td bgcolor='green'>");
						}
						for(int i=1;i<=9;i++){
							int r=newj*i;
							out.print(newj+" X"+i+"="+r+"<br>");
						}
					}	
					out.print("</td>");
					out.print("</tr>");
			    }	
			%>
	</table>
</body>
</html>