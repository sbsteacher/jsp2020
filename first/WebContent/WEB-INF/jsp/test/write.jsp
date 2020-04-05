<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
	<form action="/write" id="frm" method="post" onsubmit="return check()">
		<div>번호: <input type="number" name="pk"></div>
		<div>내용: <textarea name="val"></textarea></div>
		<div><input type="submit" value="저장"></div>
	</form>
	<script>
		function check() {			
			if(frm.pk.value == '') {
				alert('번호를 입력해 주세요')
				frm.pk.focus()
				return false	
			} else if(frm.val.value == '') {
				alert('내용을 입력해 주세요')
				frm.val.focus()
				return false	
			}
			
		}
	</script>
</body>
</html>