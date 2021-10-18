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
import com.model.LectureVO;
import com.model.MemberVO;
import com.model.StudyMemberDAO;
import com.model.StudyVO;

//마이페이지에서 COURSE와 자신이 만든 스터디를 볼 수 있어야 함
@WebServlet("/Study_MypageView")
public class Study_MypageView extends HttpServlet {
	private static final long serialVersionUID = 1L;
  

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//마이페이지에서 자신이 만든 스터디를 볼 수 있는 창
		//세션객체생성->아이디를 이용해 회원번호를 꺼내오기 위함
		HttpSession session = request.getSession();
		MemberVO vo2 = (MemberVO)session.getAttribute("Member");
		int member_no = vo2.getMember_no();
		StudyMemberDAO dao = new StudyMemberDAO();
		
		ArrayList<StudyVO> list = dao.StudyMember_Select(member_no);
		
		if (list != null) {
			
			// 내 강의정보를 세션에 저장
			session.setAttribute("StudyMy", list);
			
			// 마이페이지로 이동
			response.sendRedirect("mystudy.jsp");
		}	
	}

}
