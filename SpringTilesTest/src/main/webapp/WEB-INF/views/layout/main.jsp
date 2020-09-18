<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<tiles:insertAttribute name="asset"></tiles:insertAttribute>

</head>
<body>
	<!-- views > layout > main.jsp -->
	<!-- 레이아웃 페이지 -->
	<main>
		<tiles:insertAttribute name="mainmenu"></tiles:insertAttribute>
		<tiles:insertAttribute name="submenu"></tiles:insertAttribute><!-- 특정페이지에 들어가는 이름 멤버메뉴일때도 있지만 어드민 메뉴인 경우도 존재 소스 관리할때 헷갈리지 말라고 -->
		<tiles:insertAttribute name="content"></tiles:insertAttribute><!-- 특정페이지에 들어가는 이름 -->
	</main>
		
</body>
</html>
