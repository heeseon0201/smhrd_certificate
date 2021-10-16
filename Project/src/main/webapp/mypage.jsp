<%@page import="com.model.LectureVO"%>
<%@page import="com.model.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="Profileport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
    <title>마이페이지</title>
    <link rel="stylesheet" href="mypage.css">
</head>

<body>
    <div id= "total">
    
     <%
     	//session으로 하니 안됨, session2로 함
     	HttpSession session2 = request.getSession();
		MemberVO vo = (MemberVO)session.getAttribute("Member");
		
		// 로그인으로 가져온 VO로부터 id 가져오기
		String member_id = vo.getMember_id();  // 회원아이디
		String member_address= vo.getMember_address();  // 주소
		String member_interest = vo.getMember_interest();  // 관심분야
		String member_job = vo.getMember_job();  // 직업
		String member_NM = vo.getMember_NM(); // 이름
		String member_pw =	vo.getMember_pw();  // 비밀번호
		String member_tel = vo.getMember_tel();  // 전화번호
		int member_no = vo.getMember_no();  // 회원번호
		
		%>
        <div id = "header" class="Profile_membership" role = "banner">
            <h1>
                <a href = "main.jsp" class = "h_logo">
                    <span> Studynet </span>
                </a>
            </h1>
			
            <form id = "Profile_form" method="post" action="JoinService">
                <div id= "container" role="main">
                    <div id = "content"> 
                        <div class="c_header"> 
                            <h2>마이페이지</h2>
                            <p class="contxt"></p>
                        </div>

                        <div class="Profile_content"> 
                            <div class="row_group">
                                <div class="Profile_row">
                                    <table>
                                        <tbody>
                                            <tr>
                                                <td width="100px">
                                                    <h3 class = "Join_id">
                                                        아이디
                                                    </h3>
                                                </td>
                                                <td>
                                                    <span class="ps_box int_id">
                                                        <%=member_id %>
                                                    </span>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td colspan="2">
                                                    <!-- 제대로 입력시 글자색과 내용바뀌게 설계해보자 -->
                                                </td>
                                            </tr>

                                            <tr>
                                                <td width="100px">
                                                    <h3 class = "Join_name">
                                                       이름
                                                    </h3>
                                                </td>
                                                <td>
                                                    <span class="ps_box int_name">
                                                       <%= member_NM %>
                                                    </span>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td width="100px">
                                                    <h3 class = "Join_tel">
                                                       전화번호
                                                    </h3>
                                                </td>
                                                <td>
                                                    <span class="ps_box int_tel">
                                                       <%=member_tel %>
                                                    </span>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td width="100px">
                                                    <h3 class = "Join_address">
                                                        주소
                                                    </h3>
                                                </td>
                                                <td>
                                                    <span class="ps_box int_address">
                                                        <%=member_address %>
                                                    </span>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>

                                <div>&nbsp;</div>
<!-- 표 -->
<div class="articleBoard">
<table>
	<!-- lecture.jsp를 참고하여 자신이 신청한 강의정보 볼 수 있는 테이블 만들기 -->
           
        </table>
        <table>
        <!-- study.jsp를 참고하여 자신이 가입한 스터디 정보 볼수 있는 테이블 만들기-->
        </table>
    </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
           
        </div>
        </div>
  
</body>
</html>