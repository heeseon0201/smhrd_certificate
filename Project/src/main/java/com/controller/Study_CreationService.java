package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.StudyDAO;

@WebServlet("/Study_CreationService")
public class Study_CreationService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		
		// 스터디조직 생성 form에 작성한 값 받아오기
		String study_name = request.getParameter("name");	// 스터디명
		String study_begin = request.getParameter("begin");	// 시작일자
		String study_end = request.getParameter("end");	// 종료일자
		String study_sub = request.getParameter("sub");	// 스터디과목
		String study_place = request.getParameter("place");	// 장소
		String study_week = request.getParameter("week");	// 요일
		String study_time = request.getParameter("time");	// 시간
		String study_onoff = request.getParameter("onoff");	// 온/오프라인 구분
		
		StudyDAO dao = new StudyDAO();
		int cnt = dao.Study_Creation(study_name, study_begin, study_end, study_sub, study_place, study_week, study_time, study_onoff);
		
		// 스터디 조직 생성 후 수행할 활동
		if (cnt>0) {
			// 세션 객체 생성
			HttpSession session = request.getSession();
			
			// 생성한 스터디 조직 이름을 세션에 저장
			session.setAttribute("StudyCreation", study_name);
			
			// 스터디 조직 생성 성공하면 스터디 조직 게시판으로 이동(회원가입 성공페이지에서 id와 함께 환영메시지 띄우는 식으로 사용가능)
			response.sendRedirect("스터디조직게시판.jsp");
		}
		
	}

}
