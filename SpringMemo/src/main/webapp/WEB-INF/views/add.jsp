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
	<!-- add.jsp -->
	<div class="container">
		<h1 class="page-header">Spring Memo</h1>
		<section>
			<ul class="breadcrumb">
				<li>Memo</li>
				<li class="active">Add</li>
			</ul>
		</section>
		
		<form method="POST" action="/spring/addok.action">
			<table class="table table-bordered tblAdd">
				<tr>
					<th>이름</th>
					<td><input type="text" name="name" required class = "form-control"></td><!-- name 의 이름이 DTO 의 이름과 같아야  즉 name 으로 지정해야 한다!(대소문자도 가리니까 똑같이 만들어야 한다!.) spring 의 도움을 많이 받을 수 있다. -->
				</tr>
				<tr>
					<th>메모</th>
					<td><input type="text" name="memo" required class = "form-control"></td>
				</tr>
			</table>
				<input type="submit" value="등록하기" class="btn btn-default">
		</form>
		
	</div>
	
	<script>
	
	</script>
</body>
</html>











