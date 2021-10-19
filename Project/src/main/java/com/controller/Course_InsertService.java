package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.CourseDAO;
import com.model.CourseVO;
import com.model.MemberDAO;
import com.model.MemberVO;

// 강의정보 페이지에서 강의를 선택버튼을 누르면 실행
@WebServlet("/Course_Insert")
public class Course_InsertService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int lecture_no = 0;
		request.setCharacterEncoding("euc-kr");
		//세션객체생성->아이디를 이용해 회원번호를 꺼내오기 위함
		HttpSession session = request.getSession();
		MemberVO vo2 = (MemberVO)session.getAttribute("Member");
		int member_no = vo2.getMember_no();
		MemberDAO dao = new MemberDAO();
		
		lecture_no = Integer.parseInt(request.getParameter("lecture_no"));	// 강의번호
		
		
		// 선택한 강의가 이미 선택된건지 아닌지 확인
		// CourseDAO의 Course_Select를 실행해서 값이 선택되면 이미 강의가 이미 선택된걸로 판단
		CourseDAO dao2 = new CourseDAO();
		CourseVO vo = dao2.Course_Select(member_no, lecture_no);
		
		if(vo == null) {
			// CourseDAO의 Course_insert 실행
			int cnt = dao2.Course_Insert(member_no, lecture_no);
			vo = dao2.Course_Select(member_no, lecture_no);
			
			if (cnt>0) {	
			// 세션 객체 생성
			HttpSession session1 = request.getSession();
			
			// 선택한 강의 정보를 세션에 저장
			session1.setAttribute("Course_Selected", vo);
			
			// 강의선택 성공 페이지로 이동
			response.sendRedirect("lectureJoinSuccess.jsp");
			}
		} else {
			System.out.println("이 강의는 이미 선택되었습니다.");
			//강의 이미 선택되었을 때 알림창 띄우기 
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('이 강의는 이미 선택되었습니다.'); location.href='lecture.jsp';</script>");
			out.flush();
		}
	}

}
