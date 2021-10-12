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

@WebServlet("/MemberUpdateService")
public class MemberUpdateService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		
		HttpSession session = request.getSession();
		MemberVO vo = (MemberVO)session.getAttribute("Member");
		
		// 로그인으로 가져온 VO로부터 id 가져오기
		String id = vo.getMember_id();
		
		// 입력받은 수정할 정보를 변수에 저장 
		String new_NM = request.getParameter("name");	// 이름
		String new_tel = request.getParameter("tel");	// 전화번호
		String new_address = request.getParameter("address");	// 주소
		String new_interest = request.getParameter("interest");	// 관심분야
		String new_job = request.getParameter("job");	// 직업
		String new_pw = request.getParameter("pw");	// 비밀번호
		
		// update 메소드실행
		MemberDAO dao = new MemberDAO();
		int cnt = dao.Update(id, new_pw, new_NM, new_tel, new_address, new_interest, new_job);
		
		if(cnt>0) {
			// 수정된 정보에 대한 vo객체 생성
			MemberVO new_vo = new MemberVO(id, new_NM, new_tel, new_address, new_interest, new_job, new_pw);
			
			// 세션 갱신
			session.setAttribute("Member", new_vo);
			
			// 메인페이지로 이동
			response.sendRedirect("main.jsp");
		}
	}

}
