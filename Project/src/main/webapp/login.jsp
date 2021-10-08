<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
	<link rel="stylesheet" href="main.css">
</head>
<body>
	<form action="LoginService" method="post">
		<div class="loginDiv" style="margin-top: 50px;margin-bottom: 50px">
			<h1 class="loginlogo">login</h1>
		</div>
        <table id="logintable">
            <tr>
                <td class="loginDiv">아이디</td>
                <td class="loginDiv"><input type="text" class="in" name="id"></td>
            </tr>
            <tr>
                <td class="loginDiv">비밀번호</td>
                <td class="loginDiv"><input type="password" class="in" name="pw"></td>
            </tr>
            <tr>
                <td colspan="2" class="findid">
                    <div style="float:left; text-align:center; margin-left:40px;"><a href="#">아이디찾기</a></div>
                    <div style="float:left; text-align:center; margin-left:40px;"><a href="#">비밀번호찾기</a></div>
                </td>
            </tr>
        </table>
		<div ></div>
		<div class="loginDiv" style="margin-top: 30px;">
			<input type="submit" class="in" value="로그인">
		</div>
		<div >
			
			
		</div>
	</form>
</body>
</html>