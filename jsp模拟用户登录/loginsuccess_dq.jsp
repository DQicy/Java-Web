<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	String loginUser="";
		loginUser=request.getParameter("username");
%>

欢迎你:<%=loginUser %>登陆成功!

</body>
</html>