<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
	<h1>글쓰기</h1>
	<div>
		<form action="/board/regmod" id="frm" method="post" onsubmit="return chk()">
			<input type="hidden1" name="i_board" value="${data.i_board}">
			<div><input type="text" name="title" placeholder="제목" value="${data.title}"></div>
			<div>
				<textarea name="content" placeholder="내용">${data.content}</textarea>
			</div>
			<div>
				<input type="password" name="pw" placeholder="비밀번호">
			</div>
			<div>
				<input type="submit" value="글쓰기">
			</div>
		</form>
	</div>
	<script>
		function chk() {
			if(frm.title.value.length < 2) {
				alert('제목을 작성해 주세요')
				frm.title.focus()
				return false
			} else if(frm.content.value == '') {
				alert('내용을 작성해 주세요')
				frm.content.focus()
				return false
			} else if(frm.pw.value.length < 4) {
				alert('비밀번호를 작성해 주세요 (최소 4자리)')
				frm.pw.focus()
				return false
			}
		}
	</script>
</body>
</html>



