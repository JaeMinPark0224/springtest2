	<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="../error/errorUnknwon.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>

</head>
<body>
<div><button type="button" onclick="location.href='<%=request.getContextPath() %>/'">홈</button></div>
	<c:choose>
<c:when test="${empty boardlist}">
	<div>작성된 글이 없습니다.</div>
</c:when>
<c:otherwise>
	<div>
		<table border="1">
			<tr>
				<td>답글쓰기</td>
				<td>level</td>	
				<td>ref</td>	
				<td>rref</td>	
				<td>seq</td>			
				<td>번호</td>
				<td>제목</td>
				<td>작성일</td>
				<td>작성자</td>
				<td>조회수</td>				
			</tr>
<c:forEach items="${boardlist }" var="board">
			<tr>
				<td><a href="<%=request.getContextPath()%>/board/write?refnum=${board.board_num }">답글쓰기</a></td>
				<td>${board.board_level }</td>	
				<td>${board.board_ref }</td>	
				<td>${board.board_reply_ref }</td>	
				<td>${board.board_reply_seq }</td>			
				<td><a href="<%=request.getContextPath()%>/board/read?board_num=${board.board_num }">${board.board_num }</a></td>
				<td>
				<c:forEach begin="1" end="${board.board_level }">
					&#8618;
				</c:forEach>
				${board.board_title }
				</td>
				<td>${board.board_date }</td>
				<td>${board.board_writer }</td>
				<td>${board.board_readcount }</td>	
			</tr>
</c:forEach>
		</table>
	</div>
</c:otherwise>
</c:choose>
</body>
</html>