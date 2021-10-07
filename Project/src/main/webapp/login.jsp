<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
	<link rel="stylesheet" href="1cha.css">
</head>
<body>
	<form action="LoginService" method="post">
		<div class="loginDiv">
			<h2>로그인</h2>
		</div>
		<div class="loginDiv">
			<p>아이디</p>
		</div>
		<div class="loginDiv">
			<input type="text" class="in" name="id">
		</div>
		<div class="loginDiv">
			<p>비밀번호</p>
		</div>
		<div class="loginDiv">
			<input type="password" class="in" name="pw">
		</div>
		<div></div>
		<div class="loginDiv">
			<input type="submit" class="in" value="로그인">
		</div>
		<div class="loginDiv">
			<a href="#">아이디찾기</a>
			<a href="#">비밀번호찾기</a>
		</div>
	</form>
</body>
</html>