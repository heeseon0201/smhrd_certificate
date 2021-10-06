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
		//로그아웃 기능 -> 세션(로그인 사용자의 정보 저장)삭제
		
		//1. 세션 객체 생성
		HttpSession session = request.getSession();
		
		//2. session 삭제(member세션만 삭제) (전부삭제, 특정 키값만 가진 세션만 삭제)
		session.removeAttribute("member");
		
		//3. main.jsp이동
		response.sendRedirect("main.jsp");
		
	}

}
