package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.MemberDAO;
import com.model.MemberVO;

@WebServlet("/ProfileService")
public class ProfileService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		
		// 이 코드를 jsp 내에서 수행할 수 있으면 삭제예정임.
		// jsp에서 getAttribute로 vo 불러오고 vo.get함수를 이용해서 회원정보 가져오는게 가능할듯
		
		HttpSession session = request.getSession();
		MemberVO vo = (MemberVO)session.getAttribute("Member");
		
		// 로그인으로 가져온 VO로부터 id 가져오기
		String id = vo.getMember_id();
		
		// 회원정보테이블에서 해당 id의 정보를 가져와서 Arraylist에 저장
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberVO> list = dao.Profile(id);
		
		// 세션생성
		if (list != null) {
			// 회원의 정보를 세션에 저장
			session.setAttribute("MemberProfile", list);
			
			// 회원정보페이지로 이동
			response.sendRedirect("profile.jsp");
		}
	}

}
