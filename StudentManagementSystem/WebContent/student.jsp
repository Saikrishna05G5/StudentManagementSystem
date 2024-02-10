<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
if(session != null && session.getAttribute("username")!=null ){
		%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>student</title>
</head>
<body>
	<h2>Student Management System</h2>
	
</body>
</html>

<%
}
else{
	response.sendRedirect("index.jsp");
}
%>