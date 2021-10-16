<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="Profileport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
    <title>회원가입</title>
    <link rel="stylesheet" href="main.css">
</head>

<body class="title">
	<div class="linkTitle">
            <h1>
                <a href = "main.jsp" class = "h_logo">
                    <span> I.Study </span>
                </a>
            </h1>
	</div>
	<form action="LoginService" method="post">
		<div class="loginDiv">
			<h2 class="loginlogo">회원가입성공</h2>
		</div>
        <table id="logintable">
            <tr>
                <td><%
					String nick = (String)session.getAttribute("MemberJoinID");
					%>
			<h1><%= nick %>를 환영합니다.</h1>
			</td>
            </tr>
            
        <tr colspan="2" class="findid"><td><a href="Logout.jsp">로그아웃</a></td></tr>
 		 </table>
		<div ></div>
		
		<div >
		
		</div>
	</form>
</body>
</html>