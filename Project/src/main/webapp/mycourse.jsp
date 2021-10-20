<%@page import="com.model.CourseDAO"%>
<%@page import="com.model.StudyVO"%>
<%@page import="com.model.LectureVO"%>
<%@page import="com.model.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
    <title>스터디 모집</title>
    <script src="https://kit.fontawesome.com/88d879a5c8.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="mypage.css">
</head>
</head>
    <!--로고-->
    <header>
        <nav class="navbar">
            <div class="navbar_logo">
                <i class="fas fa-graduation-cap"></i>
                <a href="main.jsp">I-Study</a>
            </div>
            <ul class="navbar_menu">
                <a href="main.jsp"><li>홈</li></a>
                <a href="LectureSearchService?search_words="><li>강의</li></a>
                <a href="StudySearchService?search_words="><li>스터디</li></a>
            </ul>
            <ul class="navbar_account">
                <%MemberVO vo = (MemberVO)session.getAttribute("Member"); %>
                <%if(vo == null){ %>
                    <a href="login.jsp"><li>로그인</li></a>
                    <a href="join.jsp"><li>회원가입</li></a>
                <%}else{ %>
                    <a href="Lecture_MainpageService"><li>나의 강의</li></a>
                    <a href="Study_MypageView"><li>나의 스터디</li></a>
                    <a href="logout.jsp"><li>로그아웃</li></a>
                <%}%>
            </ul>
            <a href="#" class="navbar_toggleBtn">
                <i class="fas fa-bars"></i>
            </a>
        </nav>
    </header>
    <div style="text-align: left; margin: 0%" class="title"></div>
<body class="background">
	<div>
	    <h1 class="link"><b>MyCourse</b></h1>
    </div>
    <div class="articleBoard">
	<% 
	
	ArrayList<LectureVO> list = (ArrayList<LectureVO>)session.getAttribute("LectureMy"); %>

                <table class="article" ><!-- 반복문을 이용하여 테이블을 정의 하였습니다. 나중에 데이터베이스에서 컬럼명을 변수로 가져와서 붙여넣을 것. -->
                <tr>
                    <th class="cat">카테고리</th>
                    <th class="name">강의명</th>
                    <th class="teach">강사명</th>
                    <th class="price">가격</th>
                    <th class="point">평점</th>


                </tr>
        <%for(int i = 0; i<list.size() ;i++){ %>
        <% 	LectureVO vo2 = list.get(i); 
        System.out.println(list.size());
        String lecture_cat = vo2.getLecture_cat();
		String lecture_name = vo2.getLecture_name();
		String lecture_teach = vo2.getLecture_teach();
		int lecture_price = vo2.getLecture_price();
		double lecture_point = vo2.getLecture_point();
		String lecture_url = vo2.getLecture_url();
			%>
            <tr class="boardList">
            		<td class="cat"><%=lecture_cat %></td>
                   <td class="name"><a href="<%= lecture_url%>"><%=lecture_name %></a></td>
                   <td class="teach"><%=lecture_teach %></td>
                   <td class="price"><%= lecture_price%></td>
                   <td class="point"><%=lecture_point %></td>
            </tr>
      <%} %>
           
        </table>
    </div>
    <div class="foot"></div>
</body>
</html>
</body>
</html>