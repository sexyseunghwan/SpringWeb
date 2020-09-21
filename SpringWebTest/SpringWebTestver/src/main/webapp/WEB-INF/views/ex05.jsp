<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	
	
	<form action="/spring/korea/editok.action" method="POST">
		<table>
			<tr>
				<th>번호</th>
				<td><input type="text" name = "seq"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name = "name"></td>
			</tr>
			<tr>
				<th>장소</th>
				<td><input type="text" name = "place"></td>
			</tr>
		</table>
		
		<button type="submit">전송</button>
	</form>
	
	
	
</body>
</html>