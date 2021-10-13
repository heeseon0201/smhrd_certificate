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

@WebServlet("/Lecture_MainViewService")
public class Lecture_MainViewService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		ArrayList<LectureVO> list_main = null; 
		
		// DAO의 Lecture_MainView를 실행해서 평점순으로 정렬된 강의정보 테이블 데이터 가져오기
		LectureDAO dao = new LectureDAO();
		ArrayList<LectureVO> list = dao.Lecture_MainView();
		
		// 상위 평점 4개를 list_main에 저장
		for(int i=0; i<4; i++) {
			list_main.add(list.get(i));
		}
		
		if (list != null) {
			// 세션 객체 생성
			HttpSession session = request.getSession();
			
			// 메인에 띄울 강의정보 데이터를 세션에 저장
			session.setAttribute("LectureMain", list_main);
			
			// 메인페이지로 이동
			response.sendRedirect("main.jsp");
		}
	}

}
