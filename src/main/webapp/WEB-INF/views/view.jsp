<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/css/view.css">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="header_buffer">	
	</div>
	<div class="contentWrap">
		<div class="contentArea">
			<div>
				<h2>${Contentdto.title }</h2>
				<div>
					<img alt="" src="${Contentdto.thumnail}">
				</div>
				<p>${Contentdto.content}</p>
			</div>
		</div>
		<div class="commentArea" id="commentArea">
		<!-- 일반 댓글 쓰는 부분 -->
			<div class="commentInput">
				<div class="profile_pic">
					<c:choose>
						<c:when test="${sessionScope.user_info eq null }">
							<img src="resources/image/view/default.png">
						</c:when>
						<c:otherwise>
							<c:choose>
								<c:when test="${sessionScope.user_info.profile_img == '1'}">
									<img src="resources/image/view/default.png">
								</c:when>
								<c:otherwise>
									<img src="${sessionScope.user_info.profile_img}">
								</c:otherwise>
							</c:choose>
						</c:otherwise>
					</c:choose>
				</div>
				<div class="input_section">
					<form id="commentFrm">
						<input type="hidden" value="${Contentdto.idx}" name="boardidx">
						<input name="writer" value="${sessionScope.user_info.user_id}" type="hidden">
						<textarea id="commentContent" name="content"></textarea>
						<button type="button" id="commentSubmit">댓글전송</button>
					</form>
				</div>
			</div>
			<!-- 댓글을 하나하나 표시해주는 부분 -->
			<c:forEach items="${commentList}" var="comment" varStatus="loop">
				<div class="commentBox">
					<div class="commentatorInfo">
						<p>${comment.writer} <span>${comment.postdate}</span></p>
					</div>
					<div class="commentcontent">
					${comment.content}
					</div>
				</div>
				<div class="commentExtra">
					<div>
						<span><a>추천하기</a></span>
						<span>${comment.recommended }</span>
						<a class="commentActive">reply</a>
						<a class="subCommentAreaActive">답글 보기</a>
					</div>
					<div class="commentInput">
						<div class="profile_pic">
							<c:choose>
								<c:when test="${sessionScope.user_info eq null }">
									<img src="resources/image/view/default.png">
								</c:when>
								<c:otherwise>
									<c:choose>
										<c:when test="${sessionScope.user_info.profile_img == '1'}">
											<img src="resources/image/view/default.png">
										</c:when>
										<c:otherwise>
											<img alt="유저 프로파일" src="${sessionScope.user_info.profile_img}">
										</c:otherwise>
									</c:choose>
								</c:otherwise>
							</c:choose>
						</div>
						<div class="input_section">
							<form class="subcommentFrm" >
								<input type="hidden" value="${Contentdto.idx}" name="boardidx">
								<input type="hidden" value="${comment.idx}" name="commentidx">
								<input type="hidden" value="${sessionScope.user_info.user_id}" name="writer">
								<textarea class="subcommentContent" name="content"></textarea>
								<button class="subcommentSubmit" type="button">댓글전송</button>
							</form>
						</div>
					</div>
				</div>
				<div class="subCommentArea" id="commentNum${comment.idx}">
					<c:forEach items="${subCommentMap[comment.idx]}" var="subcomment">
						<div class="subCommentBox">
							<div class="commentatorInfo">
							${subcomment.writer}
							</div>
							<div class="commentcontent">
								<c:if test="${!(subcomment.mention eq null)}">
									@${subcomment.mention}
								</c:if>
								${subcomment.content}
							</div>
						</div>
						<div class="commentExtra">
							<div>
								<span><a>추천하기</a></span>
								<span>${subcomment.recommended }</span>
								<a class="commentActive">reply</a>
							</div>
							<div class="commentInput">
								<div class="profile_pic">
									<c:choose>
										<c:when test="${sessionScope.user_info eq null }">
											<img src="resources/image/view/default.png">
										</c:when>
										<c:otherwise>
											<c:choose>
												<c:when test="${sessionScope.user_info.profile_img == '1'}">
													<img src="resources/image/view/default.png">
												</c:when>
												<c:otherwise>
													<img alt="유저 프로파일" src="${sessionScope.user_info.profile_img}">
												</c:otherwise>
											</c:choose>
										</c:otherwise>
									</c:choose>
								</div>					
								<div class="input_section">
									<form class="subcommentFrm" >
										<input type="hidden" value="${Contentdto.idx}" name="boardidx">
										<input type="hidden" value="${subcomment.commentidx}" name="commentidx">
										<input type="hidden" value="${subcomment.writer}" name="mention">
										<input type="hidden" value="${sessionScope.user_info.user_id}" name="writer">
										<textarea class="subcommentContent" name="content"></textarea>
										<button class="subcommentSubmit" type="button">댓글전송</button>
									</form>
								</div>
							</div>
						</div>
					</c:forEach>
					<c:if test="${subCommentMap[comment.idx].size() == 0}">
						<p>답글이 없습니다.</p>
					</c:if>
				</div>
			</c:forEach>
		</div>
	</div>
	<script src="resources/js/view.js"></script>
</body>
</html>