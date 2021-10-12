package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogoutService")
public class LogoutService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션 객체 생성
		HttpSession session = request.getSession();
		
		// 로그인사용자의 정보를 저장하는 세션 삭제
		session.removeAttribute("Member");
		
		// 메인페이지 이동
		response.sendRedirect("main.jsp");
	}

}
