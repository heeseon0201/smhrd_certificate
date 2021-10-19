package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.LectureDAO;
import com.model.LectureVO;

// 강의정보페이지 방문시 전체 강의정보를 보여줄 servlet 코드
@WebServlet("/Lecture_ViewAllService")
public class Lecture_ViewAllService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		// 강의정보 현재페이지 번호(페이지 번호가 1오를때 마다 +10 필요)
		int i = 1;
		
		// 페이지 번호 가져오기
//		String num = request.getParameter("page_no");
//		int page_no = Integer.parseInt(num);
//		int i = 1+(page_no-1)*10;
		
		// DAO의 Lecture_viewAll 실행해서 전체 테이블 데이터 가져오기
		LectureDAO dao = new LectureDAO();
		ArrayList<LectureVO> list = dao.Lecture_ViewAll(i);
		
		if (list != null) {
			// 세션 객체 생성
			HttpSession session = request.getSession();
			
			// 강의정보 전체 데이터를 세션에 저장
			session.setAttribute("Lecture", list);
			
			// 강의정보페이지로 이동
			response.sendRedirect("lecture.jsp");
		}	
		
	}

}
