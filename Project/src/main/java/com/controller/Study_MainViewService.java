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

//메인페이지 방문시 메인페이지에서 스터디정보를 보여줄 servlet 코드
@WebServlet("/Study_MainViewService")
public class Study_MainViewService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		
		// DAO의 Study_MainView를 실행해서 평점순으로 정렬된 강의정보 테이블 데이터 가져오기
		StudyDAO dao = new StudyDAO();
		ArrayList<StudyVO> list = dao.Study_MainView();
		
		if (list != null) {
			// 세션 객체 생성
			HttpSession session = request.getSession();
			
			// 메인에 띄울 강의정보 데이터를 세션에 저장
			session.setAttribute("StudyMain", list);
			
			// 메인페이지로 이동
			response.sendRedirect("main.jsp");
		}
		
	}

}
