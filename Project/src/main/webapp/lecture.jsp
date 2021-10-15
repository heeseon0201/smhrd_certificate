<%@page import="com.model.LectureVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>강의모아보기</title>
    <link rel="stylesheet" href="table.css">
</head>
	<div style="text-align: left; margin: 0%" class="title">
		<!--로고-->
		<header>
			<h3><a href = "main.jsp">Studynet</a></h3>
		</header>
	</div>
<body class="background">
    <h1 class="link"><b>Lecture</b></h1>
    <form class="searchForm" action="SearchResult">
        <div class="searchOut">
            <div class="search">
                <input type="text" placeholder="자격증 검색" name="search" class="searchInput" autocomplete="off">
                <button class="searchBtn" type="submit" name="click">검색</button>
            </div>
        </div>
    </form>
	<div class="articleBoard">
	<% ArrayList<LectureVO> list = (ArrayList<LectureVO>)session.getAttribute("Lecture"); %>
	<% LectureVO vo = list.get(0); 
	   vo.getLecture_name();%>
                <table class="article" ><!-- 반복문을 이용하여 테이블을 정의 하였습니다. 나중에 데이터베이스에서 컬럼명을 변수로 가져와서 붙여넣을 것. -->
                <tr>
                    <th>강의명</th>
                    <th>강사명</th>
                    <th>컨텐츠제공사이트</th>
                    <th>총 강의수</th>
                    <th>가격</th>
                    <th>평점</th>
                    <th>후기</th>
                    <th>URL</th>
                    <th>카테고리</th>
                </tr>
        <%for(int i = 0; i<12;i++){ %>
            <tr class="boardList">
                   <td>강의명<%=i+1 %></td>
                   <td>강사명</td>
                   <td>컨텐츠제공사이트</td>
                   <td>총 강의수</td>
                   <td>가격</td>
                   <td>평점</td>
                   <td>후기</td>
                   <td>URL</td>
                   <td>카테고리</td>
            </tr>
            <%} %>
           
        </table>
    </div>
    <div class="foot"></div>
</body>
</html>