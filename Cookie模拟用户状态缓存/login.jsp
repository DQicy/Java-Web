<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>用户登录</h1>
	<hr>
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
   <form name="loginForm" action="dologin.jsp" method="post">
       <table>
         <tr>
           <td>用户名：</td>
           <td><input type="text" name="username" value="<%=username %>"/></td>
         </tr>
         <tr>
           <td>密码：</td>
           <td><input type="password" name="password" value="<%=password %>" /></td>
         </tr>
         <tr>
           <td colspan="2"><input type="checkbox" name="isUseCookie" checked="checked"/>十天内记住我的登录状态</td>
         </tr>
         <tr>
           <td colspan="2" align="center"><input type="submit" value="登录"/><input type="reset" value="取消"/></td>
         </tr>
       </table>
    </form>
  </body>
</html>
