<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
[[[ ${msg } ]]]<hr>
	<form action="<%=request.getContextPath() %>/member/login" method="post">
		<div>아이디:<input type="text" name="id" required="required"></div>
		<div>비밀번호:<input type="text" name="passwd" required="required"></div>
		<button type="submit">로그인</button>
	</form>
</body>
</html>