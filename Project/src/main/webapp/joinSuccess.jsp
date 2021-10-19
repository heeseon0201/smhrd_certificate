<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입성공</title>
	<link rel="stylesheet" href="Success.css">
</head>
<body class="title">
	<div class="linkTitle">
            <h1>
                <a href = "main.jsp" class = "h_logo">
                    <span> I.Study </span>
                </a>
            </h1>
	</div>
	<%String nick = (String)session.getAttribute("MemberJoinID");%>
	
	<form action="LoginService" method="post">
		<div class="loginDiv">
			<h2 class="loginlogo">회원가입성공</h2>
		</div>
        <table id="logintable">
            <tr>
                <td class="loginDiv"><%= nick %>를 환영합니다.</td>
            </tr>
            
            <tr>
                <td colspan="2" class="findid">
                  <a href="main.jsp">메인으로 돌아가기</a>
                </td>
            </tr>
        </table>
		<div ></div>
		<div class="loginDiv" style="margin-top: 30px;">
			
		</div>
		<div >
			
			
		</div>
	</form>
</body>
</html>