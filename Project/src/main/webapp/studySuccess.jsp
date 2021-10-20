<%@page import="com.model.LectureDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="Profileport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
    <title>회원가입</title>
    <link rel="stylesheet" href="Success.css">
</head>

<body class="title">
	<div class="linkTitle">
            <h1>
                <a href = "main.jsp" class = "h_logo">
                    <span> I-Study </span>
                </a>
            </h1>
	</div>
	<form action="LoginService" method="post">
	<%
				// 세션 객체 생성
				//HttpSession session = request.getSession();
				
				// 생성한 스터디 조직 이름을 세션에 저장
				String study_name = (String)session.getAttribute("StudyCreation");
				
	%>
        
		<div ></div>
		<div >
		<table id="logintable">
            <tr>
            <td><h1>스터디가 조직되었습니다.</h1></td>
            </tr>
            <tr>
                <td>
				<h3>스터디페이지에 게시되었습니다</h3>
			</td>
            </tr>
            
        <tr colspan="2" class="findid"><td><a href="main.jsp">메인으로 돌아가기</a></td></tr>
 		 </table>
		</div>
	</form>
</body>
</html>