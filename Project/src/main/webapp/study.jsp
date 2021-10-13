<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>스터디 모집</title>
    <link rel="stylesheet" href="table.css">
</head>
</head>
	<div style="text-align: left; margin: 0%" class="title">
		<!--로고-->
		<header>
			<h3><a href = "main.jsp">Studynet</a></h3>
		</header>
	</div>
<body class="background">
	<div>
	    <h1 class="link"><b>Study</b></h1>
    <div class="searchOut">
        <div class="search">
            <input type="text" placeholder="스터디 검색" class="searchInput">
            <button class="searchBtn">검색</button>
        </div>
    </div>
	    <div class="articleBoard">
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
	            </tr>
	        <%for(int i = 0; i<12;i++){ %><!-- 반복문을 이용하여 테이블을 정의 하였습니다. 나중에 데이터베이스에서 컬럼명을 변수로 가져와서 붙여넣을 것. -->
	            <tr class="boardList">
	                <td>순번<%=i+1 %></td>
	                <td>스터디명</td>
	                <td>시작일자</td>
	                <td>종료일자</td>
	                <td>스터디 과목</td>
	                <td>장소</td>
	                <td>요일(월화수목금)</td>
	                <td>시간(공부시간 시간단위)</td>
	            </tr>
	            <%} %>
	        </table>
	    </div>

    </div>
    <div class="foot"></div>
</body>
</html>