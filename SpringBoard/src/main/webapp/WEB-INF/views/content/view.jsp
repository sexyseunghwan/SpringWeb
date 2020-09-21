<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
	.table > th {
		width: 150px;
	}
	.table > td {
		width : 450px;
	}
	pre {
		width : 630px;
	}
</style>


<div class="content">
	
	
		<table class="table table-bordered">
			<tr>
				<th>번호</th>
				<td>${dto.seq}</td>
			</tr>
			<tr>
				<th>날짜</th>
				<td>${dto.regdate}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${dto.subject}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>${dto.content}</td>
			</tr>
			<tr>
				<th>언어</th>
				<td>${dto.subject}</td>
			</tr>
			<tr>
				<th>코드</th>
				<td><pre>${code}</pre></td>
			</tr>
		</table>
		<div class="btns">
			<input type="submit" value="글쓰기" class="btn btn-default">
			<input type="button" value="돌아가기" class="btn btn-default" onclick="location.href='/spring/list.action';">
		</div>
		
	
	
			
</div>
		