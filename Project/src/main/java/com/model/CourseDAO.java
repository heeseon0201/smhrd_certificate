package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CourseDAO {
	
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
	// DB 연결 메소드
	public void getConnection() {
		try {
			// JDBC 드라이버 동적 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String user = "campus_k2_1006";
			String password = "smhrd2";
			
			// 데이터 베이스 연결객체 생성
			conn = DriverManager.getConnection(url, user, password);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	// DB close 메소드
	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//신청한 강의정보을 보여주는 메소드
	//public void course_Select() {
		
	//}
	//강의를 선택하면 Course테이블에 insert하는 구문
	public int course_insert(String member_id, int Lecture_no) {
		int cnt = 0;
		String member_no = null;
		try {
			getConnection();
			String sql1 = "select member_no from member where member_id=?";
			
			psmt = conn.prepareStatement(sql1);
			
			
			psmt.setString(1, member_id);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {		
				member_no = rs.getString("member_no");
			}
			
			
			///====================================여기부터 기록 필요================================
			//개인적 생각으로는 회원번호와 인강순번만 기록하는게 베스트
			//테이블 수정필요
			//마지막에 SEQUENCE넣어야
			//수료여부: NO
			//String sql2 = "insert into course values(?, ?, sysdate, ?, )";
			
			psmt.setString(1, member_no); //회원번호 삽입
			psmt.setInt(2, Lecture_no); //인강순번
									//수강시작일자 sysdate
			
			// sql문 실행 후 결과처리
			cnt = psmt.executeUpdate();
						
			if(cnt > 0) {
				System.out.println("강의선택 성공");
			}
						
		} catch(Exception e) {
			System.out.println("강의선택 실패");
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}
}
