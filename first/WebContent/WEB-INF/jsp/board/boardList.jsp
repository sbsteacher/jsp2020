<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
</head>
<body>
	<div>${msg}</div>
	<div>
		<a href="/board/regmod"><button>글쓰기</button></a>
	</div>
	<div>
		<table>
		<c:forEach var="item" items="${list}">
			<div>${item.title}</div>
		</c:forEach>
		</table>			
	</div>
</body>
</html>