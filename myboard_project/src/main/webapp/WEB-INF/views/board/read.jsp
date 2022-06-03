<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글읽기</title>
</head>
<body>
<div><button type="button" onclick="location.href='<%=request.getContextPath() %>/'">홈</button></div>
<c:choose>
<c:when test="${empty board}">
	<script type="text/javascript">
		
	</script>
</c:when>
<c:otherwise>
	<div>
	<c:if test="${board.board_writer eq loginSsInfo.id }">
		<form id="frmNum">
			<input type="hidden" name="board_num" value="${board.board_num }">
			<button type="button" class="btn update">수정</button>
			<button type="button" class="btn delete">삭제</button>
		</form>
		<script type="text/javascript">
			$(".btn").click(function() {
				if($(this).hasClass("update")) {
					frmNum.action = "<%=request.getContextPath()%>/board/update";
				} else {
					frmNum.action = "<%=request.getContextPath()%>/board/delete";
				}
				frmNum.method = "post";
				frmNum.submit();
			});
		</script>
	</c:if>
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
		</table>
		<div>
			내용:${board.board_content }
		</div>
		<c:if test="${not empty board.board_original_filename }">
			<div>
				첨부파일:${board.board_original_filename }
			</div>
			<div>
				<img src="<%=request.getContextPath() %>${board.board_rename_filename }">
			</div>
		</c:if>
		<hr>
		<div>답글작성</div>
		<form action="<%=request.getContextPath() %>/board/write" method="post" enctype="multipart/form-data">
			<input type="hidden" name="refnum" value="${board.board_num}">
			<div>제목:<input type="text" name="board_title" required="required"></div>
			<div>내용:<input type="text" name="board_content" required="required"></div>
			<div>파일:<input type="file" name="uploadfile"></div>
			<button type="submit">답글등록</button>
		</form>
	</div>
</c:otherwise>
</c:choose>
</body>
</html>