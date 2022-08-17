<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Main Page</title>
  <link href="<c:url value='/resources/css/cat_create.css'/>" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
  유저가 충분한 포인트를 모았다면 이곳으로 이동할 수 있게된다
  <form>
    <input name="cat_name" placeholder="원하는 게시판 이름을 넣어주세요">
    <input name="sub_cat1" value="자유게시판">
    <input name="sub_cat2" value="질문게시판">
    <input name="sub_cat3" placeholder="원하는 보조 게시판 이름을 입력해주세요">
    <input name="sub_cat4" placeholder="최대 5개까지 입력가능합니다.">
    <input name="sub_cat5">
    <button type="button" onclick="">게시판 만들기</button>
    <button type="button" onclick="">취소하기</button>
  </form>
<script src="<c:url value='/resources/js/cat_create.js'/>"></script>
</body>
</html>