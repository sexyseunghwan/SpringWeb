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
	.table textarea[name='content']{height:300px;}

</style>


<div class="content">
	
	<form method="POST" action="/spring/addok.action" enctype="multipart/form-data">
		<table class="table table-bordered">
			<tr>
				<th>제목</th>
				<td><input type="text" name="subject" class="form-control" required></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="content" class="form-control" required></textarea></td>
			</tr>
			<tr>
				<th>언어</th>
				<td>
					<select name="cseq" class="form-control" required>
						<c:forEach items="${clist}" var="cdto">
							<option value="${cdto.seq}">${cdto.name}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<th>코드</th>
				<td><input type="file" name="attach" class="form-control" required></td>
			</tr>
		</table>
		<div class="btns">
			<input type="submit" value="글쓰기" class="btn btn-default">
			<input type="button" value="돌아가기" class="btn btn-default" onclick="location.href='/spring/list.action';">
		</div>
	</form>
	
	
			
</div>
		