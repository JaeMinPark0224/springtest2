<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<!-- ID          NOT NULL VARCHAR2(15) 
PASSWD      NOT NULL VARCHAR2(15) 
NAME        NOT NULL VARCHAR2(20)  -->
	<form action="<%=request.getContextPath() %>/member/enroll" method="post">
		<div>아이디:<input type="text" name="id" required="required"></div>
		<div>비밀번호:<input type="text" name="passwd" required="required"></div>
		<div>이름:<input type="text" name="name" required="required"></div>
		<button type="submit">회원가입</button>
	</form>
</body>
</html>