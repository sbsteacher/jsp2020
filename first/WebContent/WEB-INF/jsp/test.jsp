<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int age = (int)request.getAttribute("age");	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test!!!</title>
</head>
<body>
	<h1>Test!!!</h1>
	<div>My age is <%=age %></div>
</body>
</html>