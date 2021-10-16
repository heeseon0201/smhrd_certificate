package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//마이페이지에서 COURSE와 자신이 만든 스터디를 볼 수 있어야 함
@WebServlet("/Study_MypageView")
public class Study_MypageView extends HttpServlet {
	private static final long serialVersionUID = 1L;
  

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
