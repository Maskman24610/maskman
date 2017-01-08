<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib tagdir='/WEB-INF/tags' prefix='mars'%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>自訂Tag簡單範例</title>
</head>

<body>
	<mars:MyHeader  pageName='會員專區' func='回首頁' url='http://www.ncku.edu.tw' year='2017'>
		<div>Member page</div>		
	</mars:MyHeader>
	<hr>
	<mars:Hello />
	<hr>
	<mars:M99/>
</body>
</html>