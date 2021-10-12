package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.MemberDAO;

@WebServlet("/JoinService")
public class JoinService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		
		// 회원가입 form에 작성한 값 받아오기
		String member_id = request.getParameter("member_id");	// 회원아이디
		String member_NM = request.getParameter("member_NM");;	// 이름
		String member_tel = request.getParameter("member_tel");;	// 전화번호
		String member_address = request.getParameter("member_address");;	// 주소
		String member_interest = request.getParameter("member_interest");;	// 관심분야
		String member_job = request.getParameter("member_job");;	// 직업
		String member_pw = request.getParameter("member_pw");;	// 비밀번호
		
		MemberDAO dao = new MemberDAO();
		int cnt = dao.Join(member_id, member_NM, member_tel, member_address, member_interest, member_job, member_pw);
		
		// 추후에 회원가입 후 수행할 활동 입력해야함
		if (cnt>0) {
			// 값 넘겨주기
			//request.setAttribute("joinemail", email);
			// forward 방식으로 페이지 이동
			//RequestDispatcher rd = request.getRequestDispatcher("joinSuccess.jsp");
			//rd.forward(request, response);
		}
		
	}

}
