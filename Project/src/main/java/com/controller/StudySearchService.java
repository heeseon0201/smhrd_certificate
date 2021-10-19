package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.StudyDAO;
import com.model.StudyVO;

// 스터디페이지에서 스터디를 검색할 수 있게 해 줄 servlet 코드
@WebServlet("/StudySearchService")
public class StudySearchService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		ArrayList<StudyVO> list = null;
		String words = request.getParameter("search_words");
		System.out.println("결과" + words);
		StudyDAO dao = new StudyDAO();
		// 검색창에 아무것도 입력을 안하면 전체출력, 입력시 검색수행
		if (words.equals("")) {
			// 전체출력
			list = dao.Study_SeclectAll();
		} else {
			// DAO의 Lecture_Search 실행 후 해당하는 테이블 데이터 가져오기
			list = dao.Study_Search(words);
		}
		
		if (list != null) {
			// 세션 객체 생성
			HttpSession session = request.getSession();
			
			// 강의정보 데이터를 세션에 저장
			session.setAttribute("Study", list);
			
			// 강의정보페이지로 이동
			response.sendRedirect("study.jsp");
		}
	}

}
