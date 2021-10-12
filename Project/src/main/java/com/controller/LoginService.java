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
			HttpSession session = request.getSession();
			
			session.setAttribute("MemberLogin", vo);
			
			response.sendRedirect("main.jsp");
		}
	}

}
