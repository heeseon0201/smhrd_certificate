package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.model.MemberDAO;
import com.model.MemberVO;
import com.model.StudyMemberDAO;
import com.model.StudyVO;
//스터디에 가입할 수 있어야함
@WebServlet("/Study_Join")
public class Study_Join extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	/*
	 * protected void service(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * request.setCharacterEncoding("euc-kr");
	 * 
	 * String name = request.getParameter("name");//가입할 스터디 이름 //세션에서 자신의 이름 받아오기
	 * //가입하는 메소드를 실행 //성공했으면 studyjoinsuccess로 보내기 //실패했으면 실패했다고 띄워주기
	 * 
	 * //스터디에서 참여하기 누르면 여기서 스터디회원에 등록한다. 그리고 joinsuccess로 보내준다.
	 * System.out.println(name); }
	 */
	///////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////회원가입에서 복붙함///////////////////////////////
	//스터디에서 정보 받아와서 스터디 멤버 테이블에 저장하기/////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		//스터디 선택시 받아오는 매개변수
		HttpSession session = request.getSession();//세션 생성

		int studyNo = Integer.parseInt(request.getParameter("studyNo"));//study.jsp에서 매개변수 스터디넘버 받아오기
		
		MemberVO vo = (MemberVO)session.getAttribute("Member");//세션에서 회원넘버 받아오기
		int memberNo = vo.getMember_no();//스트링으로 형변환하기
		
		//studyMemberDAO로 보내기
			StudyMemberDAO dao = new StudyMemberDAO();
			//스터디 선택시 받아오는 변수를 더 많이 만들던가 아니면 스터디 이름만으로 스터디에 저장가능하게 만들 것
			//일단 네임 하나로만 저장하게 만들었음
			int cnt = dao.study_Join(studyNo, memberNo);
			
			// 추후에 회원가입 후 수행할 활동 입력해야함
			if (cnt>0) {
				// 스터디에 가입한 멤버의 이름과 스터디 이름을 세션에 저장
				//수정할 것
				session.setAttribute("Study_no", studyNo);
				
				// 성공시 스터디 가입성공으로 보내기
				response.sendRedirect("StudyJoinSuccess.jsp");
			}
			
	
		
	}

}
