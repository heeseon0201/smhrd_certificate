package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 스터디 종료 버튼을 누르면 해당 스터디조직을 테이블에서 제거해주는 코드
@WebServlet("/Study_EndService")
public class Study_EndService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		
		// 작성 보류...(먼저 스터디조직을 만든 회원이 해당 스터디 페이지에 방문했을때 세션에 스터디 정보를 저장하는 기능을 만들필요가 있음)
	}

}
