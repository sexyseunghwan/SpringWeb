<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="/spring/resources/css/prism.css">
<script src="/spring/resources/js/prism.js"></script>


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
		
		<!-- https://prismjs.com/index.html#basic-usage -->
		<!-- 여기가서 코드 표시 이쁘게 해주자 -->
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
				<td><pre class="line-numbers" data-src="/spring/files/${dto.filename}" data-download-link><code class="language-${dto.cname}">${code}</code></pre></td><!-- white space 같은걸 그대로 살려준다.  -->
			</tr>
		</table>
		<div class="btns">
			<input type="button" value="수정하기" class="btn btn-default" onclick="location.href='/spring/edit.action?seq=${dto.seq}';">
			<input type="button" value="삭제하기" class="btn btn-default" onclick="location.href='/spring/delete.action?seq=${dto.seq}';">
			<input type="button" value="돌아가기" class="btn btn-default" onclick="location.href='/spring/list.action';">
		</div>
		
	
	
			
</div>
		