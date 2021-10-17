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
								<span><a href="mycourse.jsp" class="whiteColor">나의강의</a></span>
								<span><a href="mystudy.jsp" class="whiteColor">나의스터디</a></span>
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
	<div class="info">
		<div>
			<section>
				<div class="linkTitle">
					<a class="link" href="LectureSearchService?search_words=">Lecture</a>
				</div>
			</section>
		 <!-- 메인에 강의정보 띄워줘야, 아님 띄워주기 포기할지 생각해야 함 -->
			<section class="MOD_LIGHTBOXIMGX4">
			<div data-layout="_r">
					<div data-layout="al8 de4">
						<a href="https://unsplash.it/300/300?image=55" class="AP_lightbox">
							<figure>
								<img src="https://unsplash.it/300/300?image=55" alt="">
								<figcaption></figcaption>
							</figure>
						</a>
					</div> 
					<div data-layout="al8 de4">
						<a href="https://unsplash.it/800/600?image=56" class="AP_lightbox"
							aria-haspopup="true">
							<figure>
								<img src="https://unsplash.it/300/300?image=56" alt="">
								<figcaption></figcaption>
							</figure>
						</a>
					</div>
					<div data-layout="al8 de4">
						<a href="https://unsplash.it/800/600?image=57" class="AP_lightbox"
							aria-haspopup="true">
							<figure>
								<img src="https://unsplash.it/300/300?image=57" alt="">
								<figcaption></figcaption>
							</figure>
						</a>
					</div>
					<div data-layout="al8 de4">
						<a href="https://unsplash.it/800/600?image=58" class="AP_lightbox"
							aria-haspopup="true">
							<figure>
								<img src="https://unsplash.it/300/300?image=58" alt="">
								<figcaption></figcaption>
							</figure>
						</a>
					</div>
				</div>
			</section>
		</div>
		<div>
			<!-- 탑4 불러오고 싶으면 jsp로 for문 작성하기-->
			<section class="MOD_FEATURE">
				<div data-layout="_r">
					<div data-layout="ch8 ec4">
						<a href="#" class="MOD_FEATURE_Container"> <img
							class="MOD_FEATURE_Picture"
							src="https://unsplash.it/400/300/?random" alt="">
							<div class="MOD_FEATURE_TextContainer">
								<p class="MOD_FEATURE_Title" data-theme="_ts2">이펙티브 타입스크립트 스터디/정재남</p>
								<p class="MOD_FEATURE_Description">무료/총 16개 수업/<br>"감사합니다""😍😍😍😍😍""감사합니다!"</p>
							</div>
						</a>
					</div>
					<div data-layout="ch8 ec4">
						<a href="#" class="MOD_FEATURE_Container"> <img
							class="MOD_FEATURE_Picture"
							src="https://unsplash.it/400/300/?random" alt="">
							<div class="MOD_FEATURE_TextContainer">
								<p class="MOD_FEATURE_Title" data-theme="_ts2">데이터 과학을 위한 파이썬 NumPy Basic/yjglab</p>
								<p class="MOD_FEATURE_Description">5000/총 30개 수업 / 총 2시간 43분/"군더더기 없는 깔끔한 강의입니다.""차분하신 목소리로 좋은 강의 감사드립니다. 많이 배웠습니다!""numpy 연습가능""좋은 강의 감사합니다."
							</div>
						</a>
					</div>
					<div data-layout="ch8 ec4">
						<a href="#" class="MOD_FEATURE_Container"> <img
							class="MOD_FEATURE_Picture"
							src="https://unsplash.it/400/300/?random" alt="">
							<div class="MOD_FEATURE_TextContainer">
								<p class="MOD_FEATURE_Title" data-theme="_ts2">컴알못이 보는 컴퓨터 하드웨어 기초상식/제주코딩베이스캠프</p>
								<p class="MOD_FEATURE_Description">무료/총 14개 39분 / 39분"주변에서 컴퓨터 전공자라고 자꾸 견적 맞춰달라는데, 막상 제 자신이 컴퓨터를 잘 몰라 많이 답답했습니다. 이런 강의도 있는지 몰랐네요."""제주도에서 하드웨어 공부라 ..정말 부럽네요 좋은강의 잘듣고 갑니다"</p>
							</div>
						</a>
					</div>
					<div data-layout="ch8 ec4">
						<a href="#" class="MOD_FEATURE_Container"> <img
							class="MOD_FEATURE_Picture"
							src="https://unsplash.it/400/300/?random" alt="">
							<div class="MOD_FEATURE_TextContainer">
								<p class="MOD_FEATURE_Title" data-theme="_ts2">예제로 공부하는 Python 100 문제풀이 Part.3/유용한IT학습</p>
								<p class="MOD_FEATURE_Description">49500/총 41개 수업 / 총 12시간 25분"파이썬을 다시 공부하는 데에 도움이 많이 되는 강의입니다 추천해요!""감사합니다!""좋은 강의 감사합니다""입문자로서 기초를 다지기에 너무 좋았습니다. 감사합니다""강의 재밌네요"</p>
							</div>
						</a>
					</div>
				</div>
			</section>
		</div>
		<div>
			<table style="margin: auto;">
				<tr>
					<th colspan="4"><a class="link" href="study.jsp">GroupStudy</a></th>
				</tr>
				<tr>
					<td><a href="#" class="info"> 스터디정보1 </a></td>
					<td><a href="#" class="info"> 스터디정보2 </a></td>
					<td><a href="#" class="info"> 스터디정보3 </a></td>
					<td><a href="#" class="info"> 스터디정보4 </a></td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>