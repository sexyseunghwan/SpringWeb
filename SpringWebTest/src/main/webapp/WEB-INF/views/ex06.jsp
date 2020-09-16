<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>요청방식(GET, POST)</h1>
	
	<h2>GET</h2>
	
	<a href = "/spring/ex06ok.action">
		페이지 요청하기
	</a>
	
	<br>
	
	<form method="GET" action="/spring/ex06ok.action">
		<input type="submit" value= "페이지 요청하기">
	</form>
	
	<br>
	
	<h2>POST</h2>
	
	<form method="POST" action="/spring/ex06ok.action">
		<input type="submit" value= "페이지 요청하기">
	</form>
	
</body>
</html>