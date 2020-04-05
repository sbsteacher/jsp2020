<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.dh.first.test.TestVO" %>    
<%
	List<TestVO> list = (List<TestVO>)request.getAttribute("list");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
</head>
<body>
	<div>
		<a href="/write"><button>글쓰기</button></a>
	</div>
	<table>
		<tr>
			<th>번호</th>
			<th>내용</th>
			<th>작성일시</th>
			<th>삭제</th>
		</tr>		
		<% for(TestVO vo : list) { %>
			<tr>
				<td><%=vo.getPk() %></td>
				<td><%=vo.getVal() %></td>
				<td><%=vo.getR_dt() %></td>
				<td><button onclick="del(<%=vo.getPk() %>)">삭제</button></td>
			</tr>
		<% } %>		
	</table>
	<script>
		function del(pk) {			
			location.href="/del?pk=" + pk					
		}
	</script>
</body>
</html>









