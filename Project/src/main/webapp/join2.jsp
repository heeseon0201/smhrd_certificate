<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
    <form action="JoinService" method="post">
        <table>
            <tr>
                <h2>아이디</h2>
            </tr>
            <tr>
                <input type="text" name="id">
            </tr>
            <tr>
                <h2>비밀번호</h2>
            </tr>
            <tr>
                <input type="password" name="pw">
            </tr>
            <tr><h2></h2></tr>
            <tr>
              <input type="submit" value="로그인">
            </tr>
        </table>
    </form>
</body>
</html>