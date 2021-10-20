<%@page import="com.model.StudyDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.model.LectureDAO"%>
<%@page import="com.model.StudyVO"%>
<%@page import="com.model.LectureVO"%>
<%@page import="com.model.MemberVO"%>
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
    <title>I-Study</title>
    <script src="https://kit.fontawesome.com/88d879a5c8.js" crossorigin="anonymous"></script>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script type="text/javascript" src="main.js"></script>
    <link rel="stylesheet" href="main.css">
    <link rel="stylesheet" href="assets/css/style.min.css">
    <link rel="stylesheet" href="assets/css/modules.css">
</head>
<body>
    <div class="section" id="section1">
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
        <div class="item-bg">
            <div id="main">
				<h1>언택트 시대, 최고의 선택</h1>
				<br>
				<p>최고의 강의 선택을 도와드립니다.</p>
			</div>
		</div>
        
    </div>
    
    <%
	//main에 렉쳐 보여주는 리스트 생성하기 	
	LectureDAO dao = new LectureDAO();
	ArrayList<LectureVO> list = dao.Lecture_ViewAll(1);
	//main에 스터디 보여주는 리스트 생성
	StudyDAO dao2 = new StudyDAO();
	ArrayList<StudyVO> list2 = dao2.Study_SeclectAll();
	%>

    <div class="section" id="section2">
        <div class="info">
            <div class="linkTitle">
                <a class="link" href="LectureSearchService?search_words=&pages=1">Lecture</a>
            </div>
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
    </div>
    

    <div class="section" id="section3">
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