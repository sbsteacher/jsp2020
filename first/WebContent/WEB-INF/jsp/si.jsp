<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int age = (int)request.getAttribute("age");
	String name = (String)request.getAttribute("name");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test!!!</title>
</head>
<body>
	<h1>내 이름은 <%=name %> 입니다.</h1>
	<div>제 나이는 <%=age %>살입니다.</div>
	<a href="/car/dddd">Car로 가기</a>
</body>
</html>