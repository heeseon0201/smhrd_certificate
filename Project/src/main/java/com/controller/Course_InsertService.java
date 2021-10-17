package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.CourseDAO;
import com.model.CourseVO;

// 강의정보 페이지에서 강의를 선택버튼을 누르면 실행
@WebServlet("/Course_InsertService")
public class Course_InsertService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		int member_no = Integer.parseInt(request.getParameter("member_no"));	// 회원번호
		int lecture_no = Integer.parseInt(request.getParameter("lecture_no"));	// 강의번호
		
		// 선택한 강의가 이미 선택된건지 아닌지 확인
		// CourseDAO의 Course_Select를 실행해서 값이 선택되면 이미 강의가 이미 선택된걸로 판단
		CourseDAO dao = new CourseDAO();
		CourseVO vo = dao.Course_Select(member_no, lecture_no);
		if(vo == null) {
			// CourseDAO의 Course_insert 실행
			int cnt = dao.Course_Insert(member_no, lecture_no);
			vo = dao.Course_Select(member_no, lecture_no);
			
			if (cnt>0) {	
//			// 세션 객체 생성
			HttpSession session = request.getSession();
			
			// 선택한 강의 정보를 세션에 저장
			session.setAttribute("Course_Selected", vo);
			
			// 강의선택 성공 페이지로 이동
			response.sendRedirect("lectureJoinSuccess.jsp");
			}
		} else {
			System.out.println("이 강의는 이미 선택되었습니다.");
			
			// 강의선택 실패 페이지로 이동
			response.sendRedirect("lectureJoinFailure.jsp");
		}
	}

}
