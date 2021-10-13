package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.MemberDAO;

// 회원가입 버튼을 누르면 실행될 servlet 코드
@WebServlet("/JoinService")
public class JoinService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		
		// 회원가입 form에 작성한 값 받아오기
		String member_id = request.getParameter("id");	// 회원아이디
		String member_NM = request.getParameter("name");	// 이름
		String member_tel = request.getParameter("tel");	// 전화번호
		String member_address = request.getParameter("address");	// 주소
		String member_interest = request.getParameter("interest");	// 관심분야
		String member_job = request.getParameter("job");	// 직업
		String member_pw = request.getParameter("pwd");	// 비밀번호
		String member_repw = request.getParameter("repwd"); // 비밀번호 재확인
		
		// 비밀번호 일치여부 확인 & 필수사항 입력여부 확인
		if(member_pw.equals(member_repw) && member_id != null && member_pw != null && member_repw != null) {
			MemberDAO dao = new MemberDAO();
			int cnt = dao.Join(member_id, member_NM, member_tel, member_address, member_interest, member_job, member_pw);
			
			// 추후에 회원가입 후 수행할 활동 입력해야함
			if (cnt>0) {
				// 세션 객체 생성
				HttpSession session = request.getSession();
				
				// 회원가입한 멤버 아이디를 세션에 저장
				session.setAttribute("MemberJoinID", member_id);
				
				// 회원가입 성공페이지로 이동(회원가입 성공페이지에서 id와 함께 환영메시지 띄우는 식으로 사용가능)
				response.sendRedirect("joinSuccess.jsp");
			}
			
		} else if(!member_pw.equals(member_repw)) {
			// 비밀번호와 재입력비밀번호 불일치시의 액션
		} else {
			// 필수사항 누락시의 액션
		}
		
	}

}
