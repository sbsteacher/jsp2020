<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
	<form action="/write" method="post">
		<div>번호: <input type="number" name="pk"></div>
		<div>내용: <textarea name="val"></textarea></div>
		<div><input type="submit" value="저장"></div>
	</form>
</body>
</html>