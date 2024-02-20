<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Management System</title>
</head>
<body>
<h2>Student Management System</h2>
<h3>Login</h3>
<%
if(session.getAttribute("msg") !=null ){
	%>
	<span style="color:red">
	<%= session.getAttribute("msg") %>
	</span>
	<% 
	session.removeAttribute("msg");
	}

%>
<%
if(request.getAttribute("msg") !=null ){
	%>
	<span style="color:Orange">
	<%= session.getAttribute("msg") %>
	</span>
	<% 
	session.removeAttribute("msg");
	}

%>
<form action="login" method="post">
 Username:<input type="text" name="username"><br><br>
 Password:<input type="password" name="password"><br><br>
<input type="submit" value="login">
<input type="reset" value="Cancel">
</form>
</body>
</html>