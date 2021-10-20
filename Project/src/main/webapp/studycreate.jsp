<%@page import="com.model.MemberVO"%>
<%@page import="com.model.StudyVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
	<title>StudyCreation</title>
    <script src="https://kit.fontawesome.com/88d879a5c8.js" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="studycreate.css">
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
	
	
<body>
<!-- 스터디조직창 조직한 후, 정보는 'Study_CreatService'로 보내고, 메인페이지로 이동-->
<h1 class="link"><b>MakeStudyGroup</b></h1>

    <div>
        <form action="Study_CreationService">
            <table class="tableBasic">
                <tr>
                    <td class="tableTh">스터디명</td>
                    <td class="tableTd"><input type="text" name="name"></td>
                </tr>
                <tr>
                    <td class="tableTh">시작일자</td>
                    <td class="tableTd"><input type="date" name="begin"></td>
                </tr>
                <tr>
                    <td class="tableTh">종료일자</td>
                    <td class="tableTd"><input type="date" name="end"></td>
                </tr>
                <tr>
                    <td class="tableTh">스터디과목</td>
                    <td class="tableTd"><input type="text" name="sub"></td>
                </tr>
                <tr>
                    <td class="tableTh">장소</td>
                    <td class="tableTd"><input type="text" name="place"></td>
                </tr>
                <tr>
                    <td class="tableTh">요일</td>
                    <td class="tableTd"><select name="week" id="mm" class="sel" aria-label="월" style="height:25px; width:50px; font-size: 16px;">
                                        <option value="월">월</option>
                                        <option value="화">화</option>
                                        <option value="수">수</option>
                                        <option value="목">목</option>
                                        <option value="금">금</option>
                                        <option value="토">토</option>
                                        <option value="일">일</option>
                                        </select></td>
                </tr>
                <tr>
                    <td class="tableTh">시간</td>
                    <td class="tableTd"><input type="text" name="time"></td>
                </tr>
                <tr>
                    <td colspan="2">
                    <button type="submit" class="mkBtn">만들기</button>
                            <button type="button" class="gobackBtn" onclick="history.back()"
    style="width: 75px; height: 30px; display: inline-block; margin: 10px auto; border: 0px; background: #495057; color: #e9ecef; outline: none;">뒤로가기</button>
                    </td>
                    
                </tr>
            </table>
        </form>

    </div>
<!-- <form class="" action="Study_CreationService">
스터디조직 생성 form에 작성한 값 받아오기
	String study_name = request.getParameter("name");	// 스터디명
	String study_begin = request.getParameter("begin");	// 시작일자
	String study_end = request.getParameter("end");	// 종료일자
	String study_sub = request.getParameter("sub");	// 스터디과목
	String study_place = request.getParameter("place");	// 장소
	String study_week = request.getParameter("week");	// 요일
	String study_time = request.getParameter("time");	// 시간
	String study_onoff = request.getParameter("onoff");	// 온/오프라인 구분이 
	private String SM_notice;	// 공지내용을 여기에다가 작성해야 함
	Study_CreationService으로 보낼 정보 이것을 입력할 테이블 필요
		
	
		<table>
		
		</table>
</form> -->
</body>
</html>