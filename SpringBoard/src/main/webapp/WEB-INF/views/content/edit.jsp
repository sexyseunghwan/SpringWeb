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
	
	.filename {
		text-align : left;
		margin: 5px 0px 0px 5px;
	}
</style>


<div class="content">
	
	<form method="POST" action="/spring/editok.action" enctype="multipart/form-data">
		<table class="table table-bordered">
			<tr>
				<th>제목</th>
				<td><input type="text" name="subject" class="form-control" required value="${dto.subject}"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="content" class="form-control" required >${dto.content}</textarea></td>
			</tr>
			<tr>
				<th>언어</th>
				<td>
					<select name="cseq" class="form-control" required id="cseq">
						<c:forEach items="${clist}" var="cdto">
							<option value="${cdto.seq}">${cdto.name}</option>
						</c:forEach>
					</select>
					<script>
						document.getElementById("cseq").value = "${dto.cseq}";
					</script>
				</td>
			</tr>
			<tr>
				<th>코드</th>
				<td>
					<input type="file" name="attach" class="form-control">
					<div class="filename">첨부파일 : ${dto.filename}</div>
					<input type="hidden" name="filename" value="${dto.filename}"><!-- 주개가 동시에 넘어가면 파일을 바꿀거라는 말이고 하나만 넘어가면 안바꾸겠다는 뜻이 된다. -->
				</td>
			</tr>
		</table>
		<div class="btns">
			<input type="submit" value="수정하기" class="btn btn-default">
			<input type="button" value="돌아가기" class="btn btn-default" onclick="location.href='/spring/view.action?seq=${dto.seq}';">
		</div>
		
		<input type="hidden" name="seq" value="${dto.seq}">
	</form>
	
	
			
</div>
		