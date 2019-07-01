<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>用户信息</h1>
<%
	String username="";
	String password="";
	Cookie[] cookies=request.getCookies();
	if(cookies!=null && cookies.length>0){
		for(Cookie cookie:cookies){
			if(cookie.getName().equals("username"))
				username=cookie.getValue();
			if(cookie.getName().equals("password"))
				password=cookie.getValue();
		}
	}
%>
<br>
<br>
<br>
用户名：<%=username %>
密码：<%=password %>
</body>
</html>