package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.memberVO;
import com.model.messageDAO;

@WebServlet("/DeleteService")
public class DeleteService extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// session 으로 로그인한 정보 가져오기
		HttpSession session = request.getSession();
		memberVO vo = (memberVO) session.getAttribute("member");
		
		messageDAO dao = new messageDAO();
		//매개변수로 받는 email = 내가 로그인한 email
		int cnt = dao.DeleteService(vo.getEmail());
		
		if(cnt>0) {
			System.out.println("메시지 전체 삭제 성공");
		}else {
			System.out.println("메시지 전체 삭제 실패");
		}
		response.sendRedirect("main.jsp");
		
	}

}
