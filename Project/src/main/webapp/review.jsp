<%@page import="com.model.MemberVO"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="com.model.LectureDAO"%>
<%@ page language="java" contentType="text/html; charset=euc-kr"
    pageEncoding="euc-kr"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="euc-kr">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
    <title>강의모아보기</title>
    <script src="https://kit.fontawesome.com/88d879a5c8.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="table.css">
</head>
	<div style="text-align: left; margin: 0%" class="title">
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
	</div>
<body class="background">
    <h1 class="link"><b>Review</b></h1>
    <form class="searchForm" action="LectureSearchService">
    <%
    request.setCharacterEncoding("euc-kr");
    //받아온 lecture_no를 int타입으로 변경하여 저장
    int lecture_no = Integer.parseInt(request.getParameter("lecture_no"));
    LectureDAO dao = new LectureDAO();
    String[] reviewlist = dao.Lecture_SelectReview(lecture_no);
    %>
 
    </form>
	<div class="articleBoard">
	

                <table class="article" >
                <tr>
                    <th class="reviewtable">후기</th>
                </tr>
                <!-- 리뷰없을때 구현하기 -->
					<%if(reviewlist!=null){ %>
	                <% for(int i=0; i < reviewlist.length; i++){%>
			        <tr>   
						<td><%=reviewlist[i] %></td>
			        </tr>
		         	<%}%>
		         	<%}else{ 
			  			//리뷰가 비었을때 알람 띄우기 
			  			response.setContentType("text/html; charset=UTF-8");
			  			//PrintWriter out = response.getWriter();
			  			out.println("<script>alert('리뷰가 없습니다.'); location.href='lecture.jsp';</script>");
			  			out.flush();
		         	} %>
                </table>
    </div>
    <button class="gobackBtn" onclick="history.back()"
    style="width: 100px; height: 35px; font-size: 18px; display: block; margin: 30px auto;">뒤로가기</button>
    <div class="foot"></div>
</body>
</html>