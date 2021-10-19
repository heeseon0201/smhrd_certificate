package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.MemberDAO;

@WebServlet("/PW_FindService")
public class PW_FindService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		
		// 아이디찾기 form에 작성한 값 받아오기
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		System.out.println("아이디 : " + id);
		System.out.println("이름 : " + name);
		
		MemberDAO dao = new MemberDAO();
		String pw = dao.PW_Find(id, name);
		
		if (id != null) {
			System.out.println("세선실행");
			// 세션 객체 생성
			HttpSession session = request.getSession();
			
			// 찾은 사용자의 아이디를 세션에 저장
			session.setAttribute("MemberPW", pw);
			
			// 메인페이지로 이동
			response.sendRedirect("main.jsp");
		}
	}

}
