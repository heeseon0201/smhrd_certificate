package com.compo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SearchResult")
public class SearchResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String data = request.getParameter("search");
		System.out.println("전달받은 값>> "+data);
		//사용자에게 데이터를 전달
		response.setContentType("text/html; charset=utf-8");
		
		//사용자에게 데이터를 전송하기 위한 객체생성
		PrintWriter out = response.getWriter();
		
		//데이터 전송--> 브라우저에 출력
		out.print("<h1>요청에 대한 처리 완료!</h1>");
		out.print("전달받은 값>> "+data);
		//html 어떻게 가져올 것인가
	}

}
