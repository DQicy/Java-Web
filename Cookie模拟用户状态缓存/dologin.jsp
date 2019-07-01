<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>登录成功</h1>
<br>
<br>
<br>
<%
	String[] isUseCookies=request.getParameterValues("isUseCookie");
	if(isUseCookies!=null && isUseCookies.length>0){
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		Cookie usernameCookie=new Cookie("username",username);
		Cookie passwordCookie=new Cookie("password",password);
		usernameCookie.setMaxAge(864000);
		passwordCookie.setMaxAge(864000);
		response.addCookie(usernameCookie);
		response.addCookie(passwordCookie);
	}else{
		Cookie[] cookies=request.getCookies();
		if(cookies!=null && cookies.length>0){
			for(Cookie cookie:cookies){
				if(cookie.getName().equals("username")||cookie.getName().equals("password")){
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
					
			}
		}
	}
%>
<a href="user.jsp">查看用户信息</a>

</body>
</html>