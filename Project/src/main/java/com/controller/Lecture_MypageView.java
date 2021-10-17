package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.CourseDAO;
import com.model.CourseVO;
import com.model.LectureDAO;
import com.model.LectureVO;
import com.model.MemberDAO;
import com.model.MemberVO;

// 마이페이지에서 강의정보를 보여줄 기능
@WebServlet("/Lecture_MainpageService")
public class Lecture_MypageView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		
		//마이페이지에서 자신이 만든 스터디를 볼 수 있는 창
		//세션객체생성->아이디를 이용해 회원번호를 꺼내오기 위함
		HttpSession session = request.getSession();
		MemberVO vo2 = (MemberVO)session.getAttribute("Member");
		int member_no = vo2.getMember_no();
		CourseDAO dao = new CourseDAO();
		
		ArrayList<LectureVO> list = dao.Course_mypage(member_no);
		
		if (list != null) {
		
			// 내 강의정보를 세션에 저장
			session.setAttribute("LectureMy", list);
			
			// 마이페이지로 이동
			response.sendRedirect("mycourse.jsp");
		}	
	}

}