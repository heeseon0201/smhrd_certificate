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
    <title>스터디 모집</title>
    <link rel="stylesheet" href="table.css">
</head>
</head>
	<div style="text-align: left; margin: 0%" class="title">
		<!--로고-->
		<header>
			<h3><a href = "main.jsp">I-Study</a></h3>
		</header>
	</div>
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
        </div>
        <div class="create">
        	<button class="createBtn" name="createClick" type="button" onclick="location.href='studycreate.jsp' ">스터디만들기</button>
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
	        
        <% 	StudyVO vo = list.get(i); 
	        String study_name = vo.getStudy_name(); //스터디명
	        String study_begin = vo.getStudy_begin(); //시작일자
	        String study_end = vo.getStudy_end(); //종료일자
	        String study_sub = vo.getStudy_sub(); //스터디과목
	        String study_place = vo.getStudy_place(); //장소
	        String study_week = vo.getStudy_week(); //요일
	        String study_time =vo.getStudy_time(); //시간
			
	        //테스트용 문자
	        int study_no = vo.getStudy_no();
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
	              <td><a href="Study_Join?<%=study_no %>">선택</a></td> 
	            </tr>
	            <%} %>
	        </table>
	    </div>

    </div>
    <div class="foot"></div>
</body>
</html>