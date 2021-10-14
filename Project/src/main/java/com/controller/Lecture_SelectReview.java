package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.LectureDAO;

// 강의정보페이지에서 특정 강의의 리뷰보기 버튼을 누르면 리뷰를 보여주는 기능 
@WebServlet("/Lecture_SelectReview")
public class Lecture_SelectReview extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		
		// 강의 번호 가져오기
		String num = request.getParameter("lecture_no");
		int lecture_no = Integer.parseInt(num);
		
		LectureDAO dao = new LectureDAO();
		
		// Lecture_SelectReview를 실행해서 리뷰 문자 배열을 가져옴
		String[] reviewlist = dao.Lecture_SelectReview(lecture_no);
		
		if (reviewlist != null) {
			// 세션 객체 생성
			HttpSession session = request.getSession();
			
			// 리뷰 데이터를 세션에 저장
			session.setAttribute("LectureReview", reviewlist);
			
			// 리뷰보는 페이지로 이동
			response.sendRedirect("리뷰보는페이지.jsp");
		} else {
			// 리뷰가 없을 경우 여는 페이지로 이동
			response.sendRedirect("리뷰가 없습니다페이지.jsp");
		}
		
	}

}
