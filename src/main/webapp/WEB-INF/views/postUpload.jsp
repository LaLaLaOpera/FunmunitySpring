<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Main Page</title>
  <link href="<c:url value='/resources/css/postUpload.css'/>" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
  글쓰기를 누른다면 올 수 있는 페이지
  <form method="post" action="postUpload">
    <ul>
      <li>
        <select onchange="changeSubSelect(this.value)">
          <c:forEach items="${board_cat}" var="category">
            <option value="${category}">${category}</option>
          </c:forEach>
        </select>
      </li>
      <li>
        <select id="subSelect">
        </select>
      </li>
    </ul>

    <button type="submit" onclick="">글쓰기</button>
    <button type="button" onclick="">취소하기</button>
  </form>
<script src="<c:url value='/resources/js/postUpload.js'/>"></script>
</body>
</html>