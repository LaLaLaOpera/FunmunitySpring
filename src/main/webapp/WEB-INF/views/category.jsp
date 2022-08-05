<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main Page</title>
<link href="resources/css/category.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="header_buffer">	
	</div>
	<div class="topContent">

	</div>
	<input id="category" hidden value="${category}">
	<div class="indexWrap">	
		<div class="contentWrap">

			<div class="lastSec">마지막 글입니다.</div>
		</div>
		<div class="rightsideWrap">
		기타정보를 넣어둔다.
		</div>
	</div>
<script src="resources/js/category.js"></script>
</body>
</html>