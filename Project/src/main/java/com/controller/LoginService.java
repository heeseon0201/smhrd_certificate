package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.MemberDAO;
import com.model.MemberVO;

@WebServlet("/LoginService")
public class LoginService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("euc-kr");
		
		// 로그인 form에 작성한 값 받아오기
		String id = request.getParameter("member_id");
		String pw = request.getParameter("member_pw");
		
		MemberDAO dao = new MemberDAO();
		MemberVO vo = dao.Login(id, pw);
		
		// 세션생성
		if (vo != null) {
			// 세션 객체 생성
			HttpSession session = request.getSession();
			
			// 로그인사용자의 정보를 세션에 저장
			session.setAttribute("Member", vo);
			
			// 메인페이지로 이동
			response.sendRedirect("main.jsp");
		}
	}

}
