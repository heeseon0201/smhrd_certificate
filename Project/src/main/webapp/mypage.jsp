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
	    <h1 class="link"><b>MyPage</b></h1>
    </div>
	    <div class="articleBoard">
	    <% 
	   
	    %>
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
	                <th>온오프라인</th>
	            </tr>
	            
	        <%/*for(int i = 0; i<study_list.size() ;i++){ */%>
        <% 	/*StudyVO vo = study_list.get(i); 
	        String study_name = vo.getStudy_name(); //스터디명
	        String study_begin = vo.getStudy_begin(); //시작일자
	        String study_end = vo.getStudy_end(); //종료일자
	        String study_sub = vo.getStudy_sub(); //스터디과목
	        String study_place = vo.getStudy_place(); //장소
	        String study_week = vo.getStudy_week(); //요일
	        String study_time =vo.getStudy_time(); //시간
	        String study_onoff = vo.getStudy_onoff(); //온오프라인구분
			
	        */
			%><!-- 반복문을 이용하여 테이블을 정의 하였습니다. 나중에 데이터베이스에서 컬럼명을 변수로 가져와서 붙여넣을 것. -->
	            <tr class="boardList">
	                <td>i+1 </td>
	                <td>study_name </td>
	                <td>study_begin </td>
	                <td>study_end </td>
	                <td>study_sub </td>
	                <td>study_place </td>
	                <td>study_week </td>
	                <td>study_time </td>
	                <td>study_onoff </td>
	            </tr>
	        <!-- 여기에 반복문 끝내는 }쳐줘야 -->
	        </table>
	    </div>
    </div>
    <div style="margin-top: 30px">
	</div>
    <div class="articleBoard">
	<% 
	 //=====이걸 아마 Lecture_MypageView.java에서 해야 할 것.
    //HttpSession session = request.getSession();
    //MemberVO vo = (memberVO)session.getAttribute("member");
    //CourseDAO course_dao = new CourseDAO();
    //===CourseDAO에서 Course_Select()메소드의 매개변수 중 하나인 int lecture를 없애야 함.
    //CourseVO vo_course= course_dao.Course_Select(vo.getMember_no());

	ArrayList<LectureVO> list = (ArrayList<LectureVO>)session.getAttribute("Lecture"); %>

                <table class="article" ><!-- 반복문을 이용하여 테이블을 정의 하였습니다. 나중에 데이터베이스에서 컬럼명을 변수로 가져와서 붙여넣을 것. -->
                <tr>
                    <th class="cat">카테고리</th>
                    <th class="name">강의명</th>
                    <th class="teach">강사명</th>
                    <th class="price">가격</th>
                    <th class="point">평점</th>


                </tr>
        <%/*for(int i = 0; i<list.size() ;i++){*/ %>
        <% 	/*Course course_vo = list.get(i); 
			String lecture_name = course_vo.getLecture_name();
			String lecture_teach = course_vo.getLecture_teach();
			String lecture_count = course_vo.getLecture_count();
			int lecture_price = course_vo.getLecture_price();
			double lecture_point = course_vo.getLecture_point();
			String lecture_review = course_vo.getLecture_review();
			String lecture_url = course_vo.getLecture_url();
			String lecture_cat = course_vo.getLecture_cat();*/
			%>
            <tr class="boardList">
            		<td class="cat">lecture_cat</td>
                   <td class="name"><a href="#">lecture_name</a></td>
                   <td class="teach">lecture_teach </td>
                   <td class="price">lecture_price</td>
                   <td class="point">lecture_point</td>
            </tr>
      <!-- 여기에 반복문 끝내는 }쳐줘야 -->
           
        </table>
    </div>
    <div class="foot"></div>
</body>
</html>