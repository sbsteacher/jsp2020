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
	<% for(TestVO vo : list) { %>
		<%=vo.getPk() %> | <%=vo.getVal() %> | <%=vo.getR_dt() %> <br>
	<% } %>
</body>
</html>