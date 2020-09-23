<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>글쓰기</h1>
	
	<form method="POST" action="/spring/addok.action"> 
	<table border>
		<tr>
			<th>제목</th>
			<td><input type="text" name="subject" required></td>
		</tr>
		<tr>
			<th>회원</th>
			<td><input type="text" name="tseq" value="1"></td>
		</tr>
	</table>
	
	<div>
		<input type="submit" value="글쓰기">
	</div>
	</form>
</body>
</html>