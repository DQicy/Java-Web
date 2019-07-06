<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>使用Eclipse创建Servlet小例子</h1>
	<a href="servlet/HelloServlet">使用Get方式请求HelloServlet</a>
	<br>
	<form action="servlet/HelloServlet" method="post">
	<input type="submit" value="使用Post方式请求HelloServlet"/>
	</form>
</body>
</html>