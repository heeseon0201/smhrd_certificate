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
import com.model.StudyDAO;
import com.model.StudyVO;


@WebServlet("/Study_ViewAllService")
public class Study_ViewAllService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		
		// DAO의 Lecture_viewAll 실행해서 전체 테이블 데이터 가져오기
		StudyDAO dao = new StudyDAO();
		ArrayList<StudyVO> list = dao.Study_SeclectAll();
		
		if (list != null) {
			// 세션 객체 생성
			HttpSession session = request.getSession();
			
			// 강의정보 전체 데이터를 세션에 저장
			session.setAttribute("Study", list);
			
			// 강의정보페이지로 이동
			response.sendRedirect("Study.jsp");
		}	
	}

}
