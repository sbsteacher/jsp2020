<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>테이블</title>
<style>
	table {
		border: 1px solid black;
	}
	td {
		border: 1px solid black;
	}
</style>
</head>
<body>
	<table>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>국적</th>
		</tr>	
		<tr>
			<td>1</td>
			<td>이순신</td>
			<td>대한민국</td>  
		</tr>
		<tr>
			<td>2</td>
			<td>강감찬</td>
			<td>대한민국</td>  
		</tr>
	</table>
	<br><br><br>
	
	<table>
		<tr>
			<td colspan="4">하하</td>			
		</tr>
		<tr>
			<td rowspan="2">2</td>
			<td>3</td>
			<td>4</td>
			<td>5</td>
		</tr>
		<tr>			
			<td>3</td>
			<td>4</td>
			<td>5</td>
		</tr>
		<tr>	
			<td>2</td>		
			<td>3</td>
			<td>4</td>
			<td>5</td>
		</tr>
	</table>
	<br><br><br>
</body>
</html>