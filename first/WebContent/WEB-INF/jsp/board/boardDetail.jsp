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
			<div style="color:red;">${msg }</div>
			<div>제목 : ${data.title}</div>
			<div>내용 : ${data.content }</div>
			<div>등록일시 : ${data.r_dt }</div>
			<div>수정일시 : ${data.m_dt }</div>
			<div>
				<input type="password" id="pw" placeholder="비번" onkeyup="buttonAble()">
				<button id="btnDel" disabled onclick="clkDel()">삭제</button>
				<button id="btnMod" disabled onclick="clkMod()">수정</button>
			</div>
		</c:otherwise>
	</c:choose>
	<script>
		function buttonAble() {
			if(pw.value.length > 0) {
				btnDel.disabled = false
				btnMod.disabled = false
			} else {
				btnDel.disabled = true
				btnMod.disabled = true
			}
		}
		
		function clkDel() {
			location.href = "/board/del?pw=" + pw.value + "&i_board=" + ${data.i_board}
		}
		
		function clkMod() {
			location.href = "/board/regmod?pw=" + pw.value + "&i_board=" + ${data.i_board}
		}
	</script>
</body>
</html>