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
	<!-- del.jsp -->
	<div class="container">
		<h1 class="page-header">Spring Memo</h1>
		<section>
			<ul class="breadcrumb">
				<li>Memo</li>
				<li class="active">Del</li>
			</ul>
		</section>
		
		<div>
			<input type="button" value="삭제하기" class = "btn btn-default" onclick="location.href='/spring/delok.action?seq=${seq}';">
			<input type="button" value="돌아가기" class = "btn btn-default" onclick="history.back();">
		</div>
		
	</div>
	
	<script>
	
	</script>
</body>
</html>











