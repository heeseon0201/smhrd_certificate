package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.CourseDAO;
import com.model.MemberVO;
import com.model.StudyDAO;
import com.model.StudyMemberDAO;

// 스터디조직 생성 버튼을 누르면 스터디조직을 생성하고 정보를 저장하는 servlet 코드
@WebServlet("/Study_CreationService")
public class Study_CreationService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		
		//마이페이지에서 자신이 만든 스터디를 볼 수 있는 창
		//세션객체생성->아이디를 이용해 회원번호를 꺼내오기 위함
		HttpSession session = request.getSession();
		MemberVO vo2 = (MemberVO)session.getAttribute("Member");
		int member_no = vo2.getMember_no();
		// 스터디조직 생성 form에 작성한 값 받아오기
		String study_name = request.getParameter("name");	// 스터디명
		String study_begin = request.getParameter("begin");	// 시작일자
		String study_end = request.getParameter("end");	// 종료일자
		String study_sub = request.getParameter("sub");	// 스터디과목
		String study_place = request.getParameter("place");	// 장소
		String study_week = request.getParameter("week");	// 요일
		String study_time = request.getParameter("time");	// 시간

		StudyDAO dao = new StudyDAO();
		int cnt = dao.Study_Creation(study_name, study_begin, study_end, study_sub, study_place, study_week, study_time, member_no);
		
		// 스터디 조직 생성 후 수행할 활동
		if (cnt>0) {
			
			// 생성한 스터디 조직 이름을 세션에 저장
			session.setAttribute("StudyCreation", study_name);
			int studyNo = dao.newStudyNo();
			
			//생성한 스터디의 번호를 세션에 저장
			session.setAttribute("newStudyNo", studyNo);
			
			// 스터디 조직 생성 성공하면 스터디 조직 게시판으로 이동(회원가입 성공페이지에서 id와 함께 환영메시지 띄우는 식으로 사용가능)
			response.sendRedirect("studySuccess.jsp");
		}else {
			System.out.println("스터디 개설 실패하여 개설창으로 이동");
			response.sendRedirect("studycreate.jsp");
		}
		
	}

}
