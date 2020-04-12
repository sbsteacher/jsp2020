<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>디테일</title>
</head>
<body>
	<c:choose>
		<c:when test="${data == null}">
			<div>잘 못 된 접근입니다!!</div>
		</c:when>
		<c:otherwise>
			
			<div>제목 : ${data.title}</div>
			<div>내용 : ${data.content }</div>
			<div>등록일시 : ${data.r_dt }</div>
			<div>수정일시 : ${data.m_dt }</div>
			
		</c:otherwise>
	</c:choose>
</body>
</html>