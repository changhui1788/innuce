<%@page import="com.mc.innuce.domain.user.dto.UserDTO"%>
<%@page import="org.openqa.selenium.Alert"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<jsp:include page="/WEB-INF/views/header/head.jsp" />

<link rel="stylesheet" type="text/css" href="/css/header.css">
<link rel="stylesheet" type="text/css" href="/css/debate.css">

<script defer src="/js/debate.js"></script>
<script defer src="/js/searchPage.js"></script>
<script>
	$(document).ready(function() {
		$('.content a').on('click', function(e) {
			if (${empty sessionScope.login_user}) {
				alert("로그인 하세요.");
			}
		});
	});
</script>
</head>
<body>
	<!-- HEADER -->
	<header>
		<div class="logo-txt-cover">
			<%@ include file="/WEB-INF/views/header/topBar.jsp"%>
		</div>

		<!-- 로고 -->
		<div class="logo-container">
			<a href="/main" class="logo-img"> <img
				src="/images/inNUCE_logo.png" />
			</a>

			<div class="logo-ex">
				<span> in NUCE <br />
				</span> <span> [인누케]<br /> 호두(껍데기) 안에 라는 뜻의 라틴어<br />
				</span> <span> = 한 마디로 요약하면<br />
				</span>
			</div>
		</div>
		<!-- 검색바 -->
		<%@ include file="/WEB-INF/views/header/searchBar.jsp"%>
	</header>

	<!-- MAIN -->
	<main>

		<div class="total-container">
			<div class="room-container">
				<div class="inner">
					<c:if test="${totalCount != 0}">
						<c:forEach items="${openDebateRoomList}" varStatus="room">
							<div class='content'>

								<a class="img-cover"
									href="/debate/${room.current.debate_room_key }"> <i
									class="fa-regular fa-comments"></i>
								</a> <a class='a' href="/debate/${room.current.debate_room_key }">
									<p id='${room.count }-1' class='room-name'>${room.current.debate_room_name }</p>
									<p id='${room.count }-2' class='room-description'>실시간 참여자 수
										: ${openDebateRoomUserConnectCountList[room.index]}</p>
									<p id='${room.count }-3' class='room-description'>전체 참여자 수
										: ${openDebateRoomUserCountList[room.index]}</p>
									<p id='${room.count }-4' class='room-description'>생성일자 :
										${room.current.debate_room_regdate}</p> <c:choose>
										<c:when test="${room.current.debate_room_status == 2 }">
											<p id='${room.count }-5' class='room-description'>열림</p>
										</c:when>
										<c:when test="${room.current.debate_room_status == 1 }">
											<p id='${room.count }-5' class='room-description'>10분 뒤
												닫힘</p>
										</c:when>
										<c:when test="${room.current.debate_room_status == 0 }">
											<p id='${room.count }-5' class='room-description'>닫힘</p>
										</c:when>
									</c:choose>
								</a>

							</div>
						</c:forEach>
					</c:if>
					<c:if test="${totalCount == 0}">
						<div class='content'>
							<p>채팅방이 존재하지 않습니다.</p>
						</div>
					</c:if>
				</div>

				<div class="paging">
					<%
					int pageCount = (Integer) request.getAttribute("pageCount");
					int totalCount = (Integer) request.getAttribute("totalCount");

					int totalPage = 0;
					if (totalCount % pageCount == 0) {
						totalPage = totalCount / pageCount;
					} else {
						totalPage = totalCount / pageCount + 1;
					}

					for (int i = 1; i <= totalPage; i++) {
					%>

					<a href="/debate?page=<%=i%>"><%=i%></a>&nbsp;
					<%
					}
					%>

				</div>

			</div>
		</div>

	</main>


 <!--TO TOP BUTTON-->
 <div id="to-top">
   <div class="material-icons">arrow_upward</div>
 </div>


</body>
</html>