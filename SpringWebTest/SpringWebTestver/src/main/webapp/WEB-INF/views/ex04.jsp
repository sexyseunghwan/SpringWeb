<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>ex04</h1>
	
	<form method="POST" action="/spring/board/addok.action">
		<table border="1">
			<tr>
				<th>제목</th>
				<td><input type="text" name = "subject"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><input type="text" name = "content"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name = "name"></td>
			</tr>
		</table>
		<input type="submit" value="글쓰기">
		<input type="hidden" name="seq" value="215">
	</form>
	
</body>
</html>