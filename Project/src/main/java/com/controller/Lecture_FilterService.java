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

@WebServlet("/Lecture_FilterService")
public class Lecture_FilterService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		ArrayList<LectureVO> list = null;
		ArrayList<String> filter = new ArrayList<String>();
		
		
		
		// 선택한 필터를 가져오는 부분(jsp파일에 맞춰서 수정필요한 부분, for문 입히기?)
		String 필터요소1 = request.getParameter("필터 태그의 name");
		// 선택한 필터를 문자열에 추가
		filter.add(필터요소1);
		
		
		LectureDAO dao = new LectureDAO();
		// 필터를 아무것도 선택을 안하면 전체출력, 선택시 검색수행
		if (filter.size()==0) {
			// 전체출력
			list = dao.Lecture_ViewAll();
		} else {
			// DAO의 Lecture_Search 실행 후 해당하는 테이블 데이터 가져오기
			list = dao.Lecture_filter(filter);
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
