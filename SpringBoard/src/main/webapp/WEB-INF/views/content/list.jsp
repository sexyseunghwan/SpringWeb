<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
	.table th:nth-child(1){width : 60px;}
	.table th:nth-child(2){width : auto;}
	.table th:nth-child(3){width : 110px;}
	.table th:nth-child(4){width : 150px;}
	
	.table td:nth-child(2) { text-align : left;}
</style>

<div class="content">
	
	<table class="table table-bordered">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>언어</th>
			<th>날짜</th>
		</tr>
		<c:forEach items="${list}" var="dto">
		<tr>
			<td>${dto.seq}</td>
			<td><a href="/spring/view.action?seq=${dto.seq}">${dto.subject}</a></td>
			<td>${dto.cname}</td>
			<td>${dto.regdate}</td>
		</tr>
		</c:forEach>
	</table>
	<div class="btns">
		<input type="submit" value="글쓰기" class="btn btn-default" onclick = "location.href='/spring/add.action';">
	</div>
			
</div>
		