<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="Profileport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
    <title>회원가입</title>
    <link rel="stylesheet" href="main2.css">
</head>

<body class="title">
	<div class="linkTitle">
            <h1>
                <a href = "main.jsp" class = "h_logo">
                    <span> I-Study </span>
                </a>
            </h1>
	</div>
	<%
	//세션삭제
	session.removeAttribute("Member");
	
	//다시보내기
	response.sendRedirect("main.jsp");
	%>

	<!--  <form action="LoginService" method="post">
		<div class="loginDiv">
			<h2 class="loginlogo">로그아웃성공</h2>
		</div>
        <table id="logintable">
            <tr>
                <td>로그아웃하셨습니다.
            </tr>
        </table>
		<div ></div>
		<div class="loginDiv" style="margin-top: 30px;">
			<a href="main.jsp">메인으로 돌아가기</a>
		</div>
		<div >
			
			
		</div>
		-->
	</form>
</body>
</html>