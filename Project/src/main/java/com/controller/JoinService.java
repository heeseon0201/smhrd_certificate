package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.memberDAO;

@WebServlet("/JoinService")
public class JoinService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("JoinService에 들어옴");
		//회원가입 form에 작성한 값 받아오기
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println("id: "+id);
		System.out.println("pw: "+pw);
		
		memberDAO dao = new memberDAO();
		int cnt = dao.join(id, pw);
		
		if(cnt>0) {
			//이메일값 넘겨주기
			//setAttribute("문자열",Object)는 오브젝트타입.
			request.setAttribute("id", id);
			//forward 방식으로 페이지 이동
			RequestDispatcher rd = request.getRequestDispatcher("joinSuccess.jsp");
			rd.forward(request, response);
		}
	}

}
