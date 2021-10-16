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
	
        <table id="logintable">
            <tr>
                <td>
			<h1>스터디조직에 성공했습니다.</h1>
			</td>
            </tr>
           <tr colspan="2" class="findid"><td><a href="main.jsp">메인으로 돌아가기</a></td></tr>
 		 </table>
		<div ></div>
		<div class="loginDiv" style="margin-top: 30px;">
			<input type="submit" class="in" value="">
		</div>
		<div >
		
		</div>
	</form>
</body>
</html>