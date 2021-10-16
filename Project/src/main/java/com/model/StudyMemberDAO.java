package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudyMemberDAO {
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
	//가입한 스터디조직을 보여주는 메소드
	//public void StudyMember_Select()
//}
	
	// 스터디 조직에 가입하는 메소드(작성중...Study와 StudyMember테이블의 중복된 부분 정리필요)
		//STUDY테이블과 STUDYMEMBER테이블에 모두 쌓기에 기록해야 함
	//매개변수로 공지사항 필요
		public int study_Join(String study_name, String study_begin, String study_end, String study_sub, String study_place, String study_week, String study_time, String study_onoff) {
			int cnt = 0;
			
			try {
				getConnection();
				
				// 스터디조직 가입 sql문(작성중...)
				String sql = "insert into StudyMember values(StudyMember_seq.nextval, ?, ?, ?, ?, ?, ?, ?)";
				
				psmt.setString(1, study_name);
				psmt.setString(2, study_begin);
				psmt.setString(3, study_end);
				psmt.setString(4, study_sub);
				psmt.setString(5, study_place);
				psmt.setString(6, study_week);
				psmt.setString(7, study_time);
				psmt.setString(8, study_onoff);
				
				cnt = psmt.executeUpdate();
				
			} catch(Exception e) {
				e.printStackTrace();
				System.out.println("스터디 조직 가입 실패");
			} finally {
				close();
			}
			return cnt;
			
		}
		// 마이페이지에서 COURSE와 자신이 가입한 스터디를 볼 수 있어야 함
		//public 
}
