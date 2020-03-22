<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>테이블 Exam</title>
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
			<td rowspan="2" colspan="2">01</td>
			<td colspan="3">02</td>
		</tr>
		<tr>
			<td>06</td>
			<td>07</td>
			<td>08</td>
		</tr>
		<tr>
			<td rowspan="3">25</td>
			<td>13</td>
			<td>14</td>
			<td>15</td>
			<td>16</td>
		</tr>
		<tr>			
			<td>17</td>
			<td>18</td>
			<td>19</td>
			<td>20</td>
		</tr>
		<tr>			
			<td>21</td>
			<td>22</td>
			<td>23</td>
			<td>24</td>
		</tr>
		<tr>			
			<td colspan="2">09</td>			
			<td>10</td>
			<td>11</td>
			<td>12</td>
		</tr>
	</table>
</body>
</html>