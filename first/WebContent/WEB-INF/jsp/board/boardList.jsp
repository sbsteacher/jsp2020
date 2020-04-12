<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
<style>
	table tr.content {
		cursor: pointer;
	}
	
	table tr.content:hover {
		background-color: #ecf0f1;
	}
</style>
</head>
<body>
	<div>${msg}</div>
	<div>
		<a href="/board/regmod"><button>글쓰기</button></a>
	</div>
	<div>
		<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>등록일</th>
		</tr>
			<c:forEach var="item" items="${list}">
				<tr class="content" onclick="moveDetail(${item.i_board})">
					<td>${item.i_board }</td>
					<td>${item.title }</td>
					<td>${item.r_dt }</td>
				</tr>
			</c:forEach>
		</table>			
	</div>
	<script>
		function moveDetail(i_board) {
			location.href = '/board/detail?i_board=' + i_board
		}
	</script>
</body>
</html>