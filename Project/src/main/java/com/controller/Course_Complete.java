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

// 수료여부 변경 버튼을 누르면 실행
@WebServlet("/Course_Complete")
public class Course_Complete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		
		int course_no = Integer.parseInt(request.getParameter("course_no"));	// 수강번호
		
		// CourseDAO의 Course_Complete를 실행해서 수료여부 변경
		CourseDAO dao = new CourseDAO();
		int cnt = dao.Course_Complete(course_no);
		
		if (cnt>0) {
			// 수정된 정보에 대한 vo객체 생성
			CourseVO new_vo = dao.Course_SelectByCourse(course_no);
			
			// 세션 갱신
			HttpSession session = request.getSession();
			session.setAttribute("Course_Selected", new_vo);
			
			// 강의페이지로 이동
			response.sendRedirect("lecture.jsp");
		}
	}

}
