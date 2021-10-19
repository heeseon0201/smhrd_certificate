<%@page import="com.model.CourseDAO"%>
<%@page import="com.model.StudyVO"%>
<%@page import="com.model.LectureVO"%>
<%@page import="com.model.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>스터디 모집</title>
    <link rel="stylesheet" href="mypage.css">
</head>
</head>
	<div style="text-align: left; margin: 0%" class="title">
		<!--로고-->
		<header>
			<h3><a href = "main.jsp">I.study</a></h3>
		</header>
	</div>
<body class="background">
	<div>
	    <h1 class="link"><b>MyCourse</b></h1>
    </div>
    <div class="articleBoard">
	<% 
	
	ArrayList<LectureVO> list = (ArrayList<LectureVO>)session.getAttribute("LectureMy"); %>

                <table class="article" ><!-- 반복문을 이용하여 테이블을 정의 하였습니다. 나중에 데이터베이스에서 컬럼명을 변수로 가져와서 붙여넣을 것. -->
                <tr>
                    <th class="cat">카테고리</th>
                    <th class="name">강의명</th>
                    <th class="teach">강사명</th>
                    <th class="price">가격</th>
                    <th class="point">평점</th>


                </tr>
        <%for(int i = 0; i<list.size() ;i++){ %>
        <% 	LectureVO vo = list.get(i); 
        System.out.println(list.size());
        String lecture_cat = vo.getLecture_cat();
		String lecture_name = vo.getLecture_name();
		String lecture_teach = vo.getLecture_teach();
		int lecture_price = vo.getLecture_price();
		double lecture_point = vo.getLecture_point();
		String lecture_url = vo.getLecture_url();
			%>
            <tr class="boardList">
            		<td class="cat"><%=lecture_cat %></td>
                   <td class="name"><a href="<%= lecture_url%>"><%=lecture_name %></a></td>
                   <td class="teach"><%=lecture_teach %></td>
                   <td class="price"><%= lecture_price%></td>
                   <td class="point"><%=lecture_point %></td>
            </tr>
      <%} %>
           
        </table>
    </div>
    <div class="foot"></div>
</body>
</html>
</body>
</html>