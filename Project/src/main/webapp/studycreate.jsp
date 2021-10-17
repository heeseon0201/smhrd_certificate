<%@page import="com.model.StudyVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	
	
	
	<title>StudyCreation</title>
	<link rel="stylesheet" href="table.css">
</head>

	<div style="text-align: left; margin: 0%" class="title">
		<!--로고-->
		<header>
			<h3><a href = "main.jsp">I-Study</a></h3>
		</header>
	</div>
	
	
<body>
<!-- 스터디조직창 조직한 후, 정보는 'Study_CreatService'로 보내고, 메인페이지로 이동-->
<h1 class="link"><b>StudyGroup</b></h1>
    <form class="studyCreate" action="Study_CreationService">
        <div class="searchOut">
            <div class="search">
                <input type="text" placeholder="스터디 검색" name="search_words" class="searchInput" autocomplete="off">
                <button class="createBtn" type="submit" name="click">만들기</button>
            </div>
            <br>
            <br>
            <br>
            <br>
        </div>
    </form>
    
   		<div class="articleBoard">
	<% ArrayList<StudyVO> list = (ArrayList<StudyVO>)session.getAttribute("Study"); %>

                <table class="article" ><!-- 반복문을 이용하여 테이블을 정의 하였습니다. 나중에 데이터베이스에서 컬럼명을 변수로 가져와서 붙여넣을 것. -->
                <tr>
                    <th class="no">스터디 번호</th>
                    <th class="name">스터디명</th>
                    <th class="begin">시작일</th>
                    <th class="end">종료일</th>
                    <th class="sub">스터디 과목</th>
                    <th class="place">장소</th>
                    <th class="week">요일</th>
                    <th class="time">시간</th>
                    <th class="onoff">온/오프라인</th>
                    <!-- <th>URL</th> -->

                </tr>
        <%for(int i = 0; i<list.size() ;i++){ %>
        <% 	StudyVO vo = list.get(i); 
			int study_no = vo.getStudy_no();
			String study_name = vo.getStudy_name();
			String study_begin = vo.getStudy_begin();
			String study_end = vo.getStudy_end();
			String study_sub = vo.getStudy_sub();
			String study_place = vo.getStudy_place();
			String study_week = vo.getStudy_week();
			String study_time = vo.getStudy_time();
			String study_onoff = vo.getStudy_onoff();
			%>

			
            <tr class="boardList">
            	   <td class="no"><%=study_no%></td>
                   <td class="name"><%=study_name%></td>
                   <td class="begin"><%=study_begin %></td>
				   <td class="end"><%=study_end %></td>
                   <td class="sub"><%=study_sub%></td>
                   <td class="place"><%=study_place%></td>
                   <td class="week"><%=study_week%></td>
                   <td class="time"><%=study_time%>"></td>
                   <td class="onoff"><%=study_onoff%></td>
            </tr>
            <%} %>
           
        </table>
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