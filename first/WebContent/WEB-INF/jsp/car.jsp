<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	String carName = (String)request.getAttribute("carName");
	double len = (double)request.getAttribute("len");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test!!!</title>
</head>
<body>
	<h1>내 차는 <%=carName %> 입니다.</h1>
	<div>차의 길이는 <%=len %>cm입니다</div>
	<a href="aaa/showInfo">sadflkjsdflkjslkdfjslkdfjklsf</a>
</body>
</html>