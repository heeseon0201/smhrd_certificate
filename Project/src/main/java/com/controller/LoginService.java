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
		//�� �޾ƿ���(�̸���, �н�����)
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		
		memberDAO dao = new memberDAO();
		memberVO vo = dao.login(email, pw);
		if(vo!=null) {
			//���� �α����ߴ����� DAo���� Ȯ���ϰ� �� �ڴ� ���⼭ ó��
			//���ǻ���: setAttribute(String Ű��, Object);
			HttpSession session=request.getSession();
			
			session.setAttribute("member", vo);
			
			response.sendRedirect("main.jsp");//������ ����ϰ��ֱ� ������ �����̷�Ʈ�� �̵��ص� ����
		}
		
		//���̺��� �����ϸ� -> �ܼ�â�� �α��μ���!
		//�������������� -> �ܼ�â�� �α��ν���!
		
	}

}