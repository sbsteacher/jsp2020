<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String fileName = (String)request.getAttribute("fileName");
	String abc = (String)request.getAttribute("abc");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=fileName %> 입니다!!!!
	<div><%=abc %></div>
</body>
</html>