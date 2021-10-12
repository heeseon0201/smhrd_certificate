<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		session.removeAttribute("member");
		//세션삭제
		//set-get-remove
		response.sendRedirect("main2.jsp");
	%>
</body>
</html>