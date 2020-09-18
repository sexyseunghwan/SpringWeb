<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring Memo</title>

<link rel="stylesheet" href="/spring/resources/css/bootstrap.css">
<link rel="stylesheet" href="/spring/resources/css/main.css">
<script src="/spring/resources/js/bootstrap.js"></script>

<style>
		
</style>

</head>
<body>
	<!-- index.jsp -->
	<div class="container">
		<h1 class="page-header">Spring Memo</h1>
		<section>
			<ul class="breadcrumb">
				<li>Memo</li>
				<li class="active">List</li>
			</ul>
		</section>
		
		<table class="table table-bordered">
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>메모</th>
				<th>날짜</th>
				<th>조작</th>
			</tr>
			
			<c:forEach items="${list}" var="dto">
				<tr>
					<td>${dto.seq}</td>
					<td>${dto.name}</td>
					<td>${dto.memo}</td>
					<td>${dto.regdate}</td>
					<td>
						<input type="button" value="수정" class = "btn btn-default" onclick="location.href='/spring/edit.action?seq=${dto.seq}';"> 
						<input type="button" value="삭제" class = "btn btn-default" onclick="location.href='/spring/del.action?seq=${dto.seq}';"> 
					</td>
				</tr>			
			</c:forEach>		
		</table>
		
		<div>
			<input type="button" value="등록하기" class = "btn btn-default" onclick="location.href='/spring/add.action';">
		</div>
		
	</div>
	
	<script>
	
	</script>
</body>
</html>











