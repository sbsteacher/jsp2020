<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.dh.first.test.TestVO" %>    
<%
	TestVO vo = (TestVO)request.getAttribute("vo");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
	<form action="/mod" id="frm" method="post" onsubmit="return check()">
		<div>번호: <%=vo.getPk() %></div>
		<div>내용: <textarea name="val"><%=vo.getVal() %></textarea></div>
		<input type="hidden" name="pk" value="<%=vo.getPk() %>">
		<div><input type="submit" value="수정"></div>
	</form>
	<script>
		function check() {			
			if(frm.val.value == '') {
				alert('내용을 입력해 주세요')
				frm.val.focus()
				return false	
			}
			
		}
	</script>
</body>
</html>