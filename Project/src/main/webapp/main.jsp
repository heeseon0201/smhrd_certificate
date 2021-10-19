<%@page import="com.model.StudyVO"%>
<%@page import="com.model.StudyDAO"%>
<%@page import="com.model.LectureVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.model.LectureDAO"%>
<%@page import="com.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Studynet</title>
<link rel="stylesheet" href="main.css">
<link rel="stylesheet" href="assets/css/style.min.css">
<link rel="stylesheet" href="assets/css/modules.css">
</head>
<body>
	<!--페이지 사진-->
	<div style="text-align: left; margin: 0%" class="title">
		<!--로고, 회원가입, 로그인-->
		<header>
			<h3>I.study</h3>
			<nav>
				<%MemberVO vo = (MemberVO)session.getAttribute("Member"); %>
				<%if(vo == null){ %>
						<span><a href="join.jsp" class="whiteColor">회원가입</a></span> 
						<span><a href="login.jsp" class="whiteColor">로그인</a></span>
						<%}else{ %>
								<span><a href="Lecture_MainpageService" class="whiteColor">나의강의</a></span>
								<span><a href="Study_MypageView" class="whiteColor">나의스터디</a></span>
								<span><a href="logout.jsp" class="whiteColor">로그아웃</a></span>
						<% }%>
			</nav>
		</header>
		
			<!--로고, 회원가입, 로그인-->
			<div id="main">
				<h1>언택트 시대, 최고의 선택</h1>
				<br>
				<p>블라블라</p>
			</div>
	</div>
	<%
	//main에 렉쳐 보여주는 리스트 생성하기 	
	LectureDAO dao = new LectureDAO();
	ArrayList<LectureVO> list = dao.Lecture_View10();
	//main에 스터디 보여주는 리스트 생성
	StudyDAO dao2 = new StudyDAO();
	ArrayList<StudyVO> list2 = dao2.Study_View10();
	%>
	<div class="info">
		<div>
			<section>
				<div class="linkTitle">
					<a class="link" href="LectureSearchService?search_words=">Lecture</a>
				</div>
			</section>
		</div>
		<div>
			<section class="MOD_FEATURE">
				<div data-layout="_r">
 					<%for(int i=0;i<4;i++){ 
						LectureVO lvo = list.get(i);
					String lecture_name = lvo.getLecture_name();
					String lecture_review = lvo.getLecture_review();
					String lecture_url = lvo.getLecture_url();
					%>
					<div data-layout="ch8 ec4">
						<a href="<%=lecture_url %>" class="MOD_FEATURE_Container"> <img class="MOD_FEATURE_Picture" src="https://unsplash.it/400/300/?random" alt="">
							<div class="MOD_FEATURE_TextContainer">
								<p class="MOD_FEATURE_Title" data-theme="_ts2"><%=lecture_name %></p>
								<p class="MOD_FEATURE_Description"><%=lecture_review %></p>
							</div>
						</a>
					</div>
					 <%} %> 
				</div>
			</section>
		</div>
		
		
		<div>
			<section>
				<div class="linkTitle">
					<a class="link" href="StudySearchService?search_words=">GroupStudy</a>
				</div>
			</section>
		</div>
		<div>
			<section class="MOD_FEATURE">
				<div data-layout="_r">
 					<%for(int i=0;i<4;i++){ 
					StudyVO svo = list2.get(i);
					String study_name = svo.getStudy_name();
					String study_sub = svo.getStudy_sub();
					%>
					<div data-layout="ch8 ec4">
						<a href="#" class="MOD_FEATURE_Container"> <img class="MOD_FEATURE_Picture" src="https://unsplash.it/400/300/?random" alt="">
							<div class="MOD_FEATURE_TextContainer">
								<p class="MOD_FEATURE_Title" data-theme="_ts2"><%=study_name %></p>
								<p class="MOD_FEATURE_Description"><%=study_sub %></p>
							</div>
						</a>
					</div>
					 <%} %> 
				</div>
			</section>
		</div>
		</div>
</body>
</html>