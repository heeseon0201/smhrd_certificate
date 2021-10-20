<%@page import="com.model.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.model.StudyVO"%>
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
	<title>스터디 모집</title>
	<script src="https://kit.fontawesome.com/88d879a5c8.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="table.css">
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
	    <h1 class="link"><b>Study</b></h1>
	    <div class="searchOut">
	    	<form class="searchForm" action="StudySearchService">
		        <div class="searchOut">
		            <div class="search">
		                <input type="text" placeholder="스터디 검색" name="search_words" class="searchInput" autocomplete="off">
		                <button class="searchBtn" type="submit" name="click">검색</button>
		            </div>
			        <div class="create">
			        	<button class="createBtn" name="createClick" type="button" onclick="location.href='studycreate.jsp' ">스터디만들기</button>
			        </div>
		        </div>
	        </form>
	        
	    </div>
	    <div class="articleBoard">
	    <% ArrayList<StudyVO> list = (ArrayList<StudyVO>)session.getAttribute("Study"); %>
	        <table class="article">
	            <tr>
	                <th>순번</th>
	                <th>스터디명</th>
	                <th>시작일자</th>
	                <th>종료일자</th>
	                <th>스터디 과목</th>
	                <th>장소</th>
	                <th>요일(월화수목금)</th>
	                <th>시간(공부시간 시간단위)</th>
	                <th>스터디선택</th>
	            </tr>
	            
	        <%for(int i = 0; i<list.size() ;i++){ %>
	        
        <% 	StudyVO vo2 = list.get(i); 
	        String study_name = vo2.getStudy_name(); //스터디명
	        String study_begin = vo2.getStudy_begin(); //시작일자
	        String study_end = vo2.getStudy_end(); //종료일자
	        String study_sub = vo2.getStudy_sub(); //스터디과목
	        String study_place = vo2.getStudy_place(); //장소
	        String study_week = vo2.getStudy_week(); //요일
	        String study_time =vo2.getStudy_time(); //시간
			
	        //테스트용 문자
	        int study_no = vo2.getStudy_no();
			%><!-- 반복문을 이용하여 테이블을 정의 하였습니다. 나중에 데이터베이스에서 컬럼명을 변수로 가져와서 붙여넣을 것. -->
	            <tr class="boardList">
	                <td><%=i+1 %></td>
	                <td><%=study_name %></td>
	                <td><%=study_begin %></td>
	                <td><%=study_end %></td>
	                <td><%=study_sub %></td>
	                <td><%=study_place %></td>
	                <td><%=study_week %></td>
	                <td><%=study_time %></td>
	                
	                <!-- 어케든 Study_Join.java로 STUDY_NO을 보내야 함-->
	              <td class="select"><a href="Study_Join?study_no=<%=study_no %>">선택</a></td> 
	            </tr>
	            <%} %>
	        </table>
	    </div>

    </div>
	<button class="gobackBtn" onclick="document.location.href='main.jsp'"
    style="width: 80px; height: 25px; font-size: 15px; display: block; margin: 30px auto;">홈으로</button>
    <div class="foot"></div>
</body>
</html>