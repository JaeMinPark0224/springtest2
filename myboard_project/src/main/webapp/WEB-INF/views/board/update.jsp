<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글수정</title>
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
	<form id="frmNum" action="<%=request.getContextPath()%>/board/updateDo" method="post" enctype="multipart/form-data">
		<table border="1">
			<tr>
				<td>번호</td>
				<td>작성일</td>
				<td>작성자</td>
				<td>조회수</td>				
			</tr>
			<tr>
				<td>${board.board_num }</a></td>
				<td>${board.board_date }</td>
				<td>${board.board_writer }</td>
				<td>${board.board_readcount }</td>	
			</tr>
		</table>
		<input type="hidden" name="board_num" value="${board.board_num }">
		<div>
			제목:<input type="text" name="board_title" value="${board.board_title }">
		</div>
		<div>
			내용:<input type="text" name="board_content" value="${board.board_content }">
		</div>
		<c:if test="${not empty board.board_original_filename }">
			<input type="hidden" name="org_filepath" value="<%=request.getContextPath() %>${board.board_rename_filename }">
			<div>첨부파일변경:<input type="file" name="uploadfile"></div>
			<div>
				첨부파일:<input type="text" name="board_original_filename" value="${board.board_original_filename }">삭제하고 싶으면 파일명을 지워주세요.
			</div>
			<div>
				<img src="<%=request.getContextPath() %>${board.board_rename_filename }">
			</div>
		</c:if>
		<button type="reset">기존값으로 초기화</button>
		<button type="submit">수정</button>
		</form>
		</div>
</c:otherwise>
</c:choose>
</body>
</html>