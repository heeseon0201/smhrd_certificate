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

@WebServlet("/LectureSearchService")
public class LectureSearchService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		ArrayList<LectureVO> list = null;
		String words = request.getParameter("search_words");
		
		LectureDAO dao = new LectureDAO();
		// 검색창에 아무것도 입력을 안하면 전체출력, 입력시 검색수행
		if (words.equals(null)) {
			// 전체출력
			list = dao.Lecture_ViewAll();
		} else {
			// DAO의 Lecture_Search 실행 후 해당하는 테이블 데이터 가져오기
			list = dao.Lecture_Search(words);
		}
		
		if (list != null) {
			// 세션 객체 생성
			HttpSession session = request.getSession();
			
			// 강의정보 데이터를 세션에 저장
			session.setAttribute("Lecture", list);
			
			// 강의정보페이지로 이동
			response.sendRedirect("lecture.jsp");
		}
		
		
	}

}
