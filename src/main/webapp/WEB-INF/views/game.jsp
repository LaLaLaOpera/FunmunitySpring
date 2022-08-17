<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Main Page</title>
  <link href="<c:url value='/resources/css/index.css'/>" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="header_buffer">
</div>
<div class="indexWrap">
  <div class="contentWrap">
  게임 컨텐츠를 여기에 넣어준다.
  </div>
</div>
<script src="<c:url value='/resources/js/index.js'/>"></script>
</body>
</html>