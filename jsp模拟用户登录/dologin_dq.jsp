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
		String username="";
		String password="";
		username=request.getParameter("username");
		password=request.getParameter("password");
		
		if(username.equals("admin")&&password.equals("admin")){
			request.setAttribute("username", "admin");
			request.getRequestDispatcher("loginsuccess_dq.jsp").forward(request, response);
			
		}else{
			response.sendRedirect("loginfailure_dq.jsp");
		}
		
		%>
</body>
</html>