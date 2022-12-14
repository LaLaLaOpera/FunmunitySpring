<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<c:url value='/resources/css/header.css'/>">
<meta charset="UTF-8">
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<body>
	<div class="modal_login">
		<div class="login_content">
			<form id="loginFrm">
				<ul>
					<li>아이디</li>
					<li><input type="text" name="user_id"></li>
				</ul>
				<ul>
					<li>비밀번호</li>
					<li><input type="password" name="user_pw"></li>
				</ul>
				<button type="button" class="loginConfirm">로그인</button>
				<button type="button" class="loginExit">창닫기</button>
			</form>
		</div>
	</div>
	<div class="modal_signUp">
		<div class="signup_content">
			<form id="signupFrm">
				<ul>
					<li>아이디</li>
					<li><input type="text" name="user_id" id="signup_id"></li>
				</ul>
				<ul>
					<li>비밀번호</li>
					<li><input type="password" name="user_pw" id="signup_pw"></li>
				</ul>
				<ul>
					<li>비밀번호 확인</li>
					<li><input type="password" name=""user_pwre id="pw_confirm"></li>
				</ul>
				<ul>
					<li>이메일</li>
					<li><input type="text" name="user_email" id="signup_mail"></li>
				</ul>
				<ul>
					<li>이름</li>
					<li><input type="text" name="user_name" id="signup_name"></li>
				</ul>
				<button type="button" class="signupConfirm">회원가입</button>
				<button type="button" class="signUpExit">창닫기</button>
			</form>
		</div>
	</div>
	<div class="headerWrap">
		<nav class="navWrap">
			<a class="logo" href="<c:url value='/'/> ">logo</a>
			<div class="searchWrap">
				<form class="searchFrm">
					<input type="text" class="search_bar">
					<button class="searchBtn"><img src="<c:url value='/resources/image/header/searchBtn.png'/>"></button>
				</form>
			</div>
			<div class="header_menu">
				<ul>
				<c:choose>
					<c:when test="${sessionScope.user_info eq null}">
						<li><a class="loginBtn">로그인</a></li>
						<li><a class="signUpBtn">회원가입</a></li>
					</c:when>
					<c:otherwise>
						<li><a onclick="logout()">로그아웃</a></li>
						<li><a href="">마이페이지</a></li>
						<li><a href="post">글쓰기</a></li>
					</c:otherwise>
				</c:choose>
					<li>
						<button type="button" id="AccordionBtn">아코디언 버튼</button>
					</li>
				</ul>
			</div>
		</nav>
		<div class="Accordion off" id="AccordionMenu">
			<ul>
				<li><a href="CreateCategory">게시판 만들기</a></li>
				<li><a href="<c:url value='post'/>">글쓰기</a></li>
				<li>더미 리스트</li>
				<li>더미 리스트</li>
				<li>더미 리스트</li>
				<li>더미 리스트</li>
				<li>더미 리스트</li>
				<li>더미 리스트</li>
				<li>더미 리스트</li>
				<li>더미 리스트</li>
				<li>더미 리스트</li>
			</ul>
		</div>
	</div>
	<script src="<c:url value='/resources/js/header.js'/>"></script>
</body>
</html>
