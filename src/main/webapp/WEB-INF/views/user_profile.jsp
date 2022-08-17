<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main Page</title>
<link href="<c:url value='/resources/css/user_profile.css'/>" rel="stylesheet">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="user_profile">
		해당유저의 정보를 불러온다
		개인정보와 관련된 정보는 표기하지 아니하고
		유저의 레벨, 유저 캐릭터의 직업
		등을 표시
		간단한 미니게임도 넣어보고 싶기때문에 미니게임 관련 스코어? 같은거도 넣고싶다.
	</div>
	<div>
		div를 사이드 배열해서 한쪽은 유저가 쓴 최근 글을 한쪽은 댓글을 표시해준다.
		<div>

		</div>
		<div>

		</div>
	</div>
	<script src="<c:url value='/resources/js/user_profile.js'/>"></script>
</body>
</html>