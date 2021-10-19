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

// 강의정보페이지에서 검색버튼 클릭시 강의정보를 검색해줄 servlet 코드
@WebServlet("/LectureSearchService")
public class LectureSearchService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		// 세션 객체 생성
		HttpSession session = request.getSession();
		
		ArrayList<LectureVO> list = null;
		String words = request.getParameter("search_words");
		String pages =  request.getParameter("pages");
		session.setAttribute("words", words);
		System.out.println("결과: " + words);
		LectureDAO dao = new LectureDAO();
		
		// 강의정보 현재페이지 번호(페이지 번호가 1오를때 마다 +10 필요)

		if(pages==null) {
			pages="1";
		}
		int i = Integer.parseInt(pages);

		
		// 검색창에 아무것도 입력을 안하면 전체출력, 입력시 검색수행
		if (words.equals("")) {
			// 전체출력
			list = dao.Lecture_ViewAll(i);
		} else {
			// DAO의 Lecture_Search 실행 후 해당하는 테이블 데이터 가져오기
			list = dao.Lecture_Search(words, i);
//			list = dao.Lecture_Search(words);
		}
		
		if (list != null) {

			
			// 강의정보 데이터를 세션에 저장
			session.setAttribute("Lecture", list);
			
			// 강의정보페이지로 이동
			response.sendRedirect("lecture.jsp");
		}
	}

}
