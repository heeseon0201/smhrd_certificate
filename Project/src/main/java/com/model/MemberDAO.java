package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MemberDAO {
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
	
	// 회원가입 메서드
	public int Join(String member_id, String member_NM, String member_tel, String member_address,
			String member_interest, String member_job, String member_pw) {
		int cnt = 0;
		
		try {
			getConnection();
			
			// 회원가입 sql문
			String sql = "insert into Member values(Member_seq.nextval, ?, ?, ?, ?, ?, ?, ?)";
			
			// SQL 실행 객체 생성
			psmt = conn.prepareStatement(sql);
			
			// 바인드 변수 채우기
			psmt.setString(1, member_id);
			psmt.setString(2, member_NM);
			psmt.setString(3, member_tel);
			psmt.setString(4, member_address);
			psmt.setString(5, member_interest);
			psmt.setString(6, member_job);
			psmt.setString(7, member_pw);
			
			// sql문 실행 후 결과처리
			cnt = psmt.executeUpdate();
			
			if(cnt > 0) {
				System.out.println("회원가입성공");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("회원가입 실패");
		} finally {
			close();
		}
		return cnt;
	}
	
	// 로그인 메소드
	public MemberVO Login(String member_id, String member_pw) {
		int cnt = 0;
		MemberVO vo = null;
		
		try {
			getConnection();
			
			// 로그인 sql문
			String sql = "select * from Member where member_id=? and member_pw=?";
			
			// SQL 실행 객체 생성
			psmt = conn.prepareStatement(sql);
			
			// 바인드 변수 채우기
			psmt.setString(1, member_id);
			psmt.setString(2, member_pw);
			
			// sql문 실행
			rs = psmt.executeQuery();
			
			// 결과처리
			if(rs.next()) {		
				System.out.println("로그인성공");
				
				int get_no = rs.getInt("member_no");
				String get_id = rs.getString("member_id");
				String get_NM = rs.getString("member_NM");
				String get_tel = rs.getString("member_tel");
				String get_address = rs.getString("member_address");
				String get_interest = rs.getString("member_interest");
				String get_job = rs.getString("member_job");
				String get_pw = rs.getString("member_pw");
				
				vo = new MemberVO(get_no, get_id, get_NM, get_tel, get_address, get_interest, get_job, get_pw);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("로그인 실패");
		} finally {
			close();
		}
		return vo;
	}
	
	// 회원정보를 출력하는 메소드
	public ArrayList<MemberVO> Profile(String member_id) {
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		
		try {
			getConnection();
			
			// 회원정보 출력 sql문
			String sql = "select * from Member where member_id=?";
			
			// SQL 실행 객체 생성
			psmt = conn.prepareStatement(sql);
			
			// 바인드 변수 채우기
			psmt.setString(1, member_id);
			
			// sql문 실행
			rs = psmt.executeQuery();
			
			// 결과처리
			if(rs.next()) {		
				int get_no = rs.getInt("member_no");
				String get_id = rs.getString("member_id");
				String get_NM = rs.getString("member_NM");
				String get_tel = rs.getString("member_tel");
				String get_address = rs.getString("member_address");
				String get_interest = rs.getString("member_interest");
				String get_job = rs.getString("member_job");
				String get_pw = rs.getString("member_pw");
				
				MemberVO vo = new MemberVO(get_no, get_id, get_NM, get_tel, get_address, get_interest, get_job, get_pw);
				list.add(vo);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	
	// 회원정보 수정 메소드
	public int Update(String id, String pw, String NM, String tel, String address, String interest, String job) {
		int cnt = 0;
		try {
			getConnection();
			
			// 회원정보 수정 sql문
			String sql = "update Member set member_pw=?, member_NM=?, member_tel=?, member_address=?, member_interest=?, member_job=? where member_id=?";
			
			// SQL 실행 객체 생성
			psmt = conn.prepareStatement(sql);
			
			// 바인드 변수 채우기
			psmt.setString(1, pw);
			psmt.setString(2, NM);
			psmt.setString(3, tel);
			psmt.setString(4, address);
			psmt.setString(5, interest);
			psmt.setString(6, job);
			psmt.setString(7, id);
			
			// sql문 실행 후 결과처리
			cnt = psmt.executeUpdate();
			
			if(cnt > 0) {
				System.out.println("회원정보 수정 성공");
			}
			
		} catch(Exception e) {
			System.out.println("회원정보 수정 실패");
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}
	
}
