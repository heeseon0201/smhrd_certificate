<%@page import="com.model.LectureDAO"%>
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
    <h1 class="link"><b>Review</b></h1>
    <form class="searchForm" action="LectureSearchService">
    <%
    request.setCharacterEncoding("euc-kr");
    //받아온 lecture_no를 int타입으로 변경하여 저장
    int lecture_no = Integer.parseInt(request.getParameter("lecture_no"));
    LectureDAO dao = new LectureDAO();
    String[] reviewlist = dao.Lecture_SelectReview(lecture_no);
    %>
 
    </form>
	<div class="articleBoard">
	

                <table class="reviewtable" >
                <tr>
                    <th class="review">후기</th>
                    <!-- <th>URL</th> -->
                </tr>
		        <tr>
		                   <% for(int i=0; i < reviewlist.length; i++){%>
								 <td><%=reviewlist[i] %></td>
								
								<% }%>
		                   <%--후기더보기 <td class="review"><%=lecture_review%></td>--%>
		                  <%--  <td><%=lecture_url%></td> --%>
		                   
		          </tr>
        </table>
    </div>
    <div class="foot"></div>
</body>
</html>