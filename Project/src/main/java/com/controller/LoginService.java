package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.memberDAO;
import com.model.memberVO;

@WebServlet("/LoginService")
public class LoginService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//값 받아오기(이메일, 패스워드)
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		memberDAO dao = new memberDAO();
		memberVO vo = dao.login(id, pw);
		if(vo!=null) {
			//누가 로그인했는지만 DAo에서 확인하고 그 뒤는 여기서 처리
			//세션생성: setAttribute(String 키값, Object);
			HttpSession session=request.getSession();
			
			session.setAttribute("member", vo);
			
			response.sendRedirect("main.jsp");//세션이 기억하고있기 때문에 리다이렉트로 이동해도 무방
		}else {
			response.sendRedirect("main.jsp");//세션이 기억하고있기 때문에 리다이렉트로 이동해도 무방
		}////일단 실패해도 메인으로 이동하게 해놨음
		
		//테이블상에 존재하면 -> 콘솔창에 로그인성공!
		//존재하지않으면 -> 콘솔창에 로그인실패!
		
	}

}
