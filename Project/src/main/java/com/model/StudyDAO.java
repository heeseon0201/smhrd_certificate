package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StudyDAO {
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
	
	// 스터디 조직 전체데이터를 보여주는 메소드
	public ArrayList<StudyVO> Study_SeclectAll() {
		ArrayList<StudyVO> list = new ArrayList<StudyVO>();
		
		try {
			getConnection();
			
			// 스터디정보 전체출력 sql문
			String sql = "select * from Study";
			
			// SQL 실행 객체생성
			psmt = conn.prepareStatement(sql);
			
			// sql문 실행
			rs = psmt.executeQuery();
			
			// 결과처리
			while(true) {
				if(rs.next()) {		
					int study_no = rs.getInt("study_no");
					String study_name = rs.getString("study_name");
					String study_begin = rs.getString("study_begin");
					String study_end = rs.getString("study_end");
					String study_sub = rs.getString("study_sub");
					String study_place = rs.getString("study_place");
					String study_week = rs.getString("study_week");
					String study_time = rs.getString("study_time");
					String study_onoff = rs.getString("study_onoff");
					
					StudyVO vo = new StudyVO(study_no, study_name, study_begin, study_end, study_sub, study_place, study_week, study_time, study_onoff);
					list.add(vo);
				}
				
				if(rs.isLast()) {
					break;
				}
			}
			System.out.println("스터디조직 출력 성공");
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("스터디조직 출력 실패");
		} finally {
			close();
		}
		return list;
	}

	
	// 스터디 조직 하나를 선택해서 보여주는 메소드
	public StudyVO Study_SelectOne(int study_no) {
		StudyVO vo = null;
		
		try {
			getConnection();
			
			// 스터디정보 선택출력 sql문
			String sql = "select * from Study where study_no=?";
			
			// SQL 실행 객체생성
			psmt = conn.prepareStatement(sql);
			
			// 바인드 변수 채우기
			psmt.setInt(1, study_no);
			
			// sql문 실행
			rs = psmt.executeQuery();
			
			// 결과처리
			if(rs.next()) {		
				System.out.println("스터디조직 일부출력 성공");
				
				String study_name = rs.getString("study_name");
				String study_begin = rs.getString("study_begin");
				String study_end = rs.getString("study_end");
				String study_sub = rs.getString("study_sub");
				String study_place = rs.getString("study_place");
				String study_week = rs.getString("study_week");
				String study_time = rs.getString("study_time");
				String study_onoff = rs.getString("study_onoff");
				
				vo = new StudyVO(study_no, study_name, study_begin, study_end, study_sub, study_place, study_week, study_time, study_onoff);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("스터디조직 일부출력 실패");
		} finally {
			close();
		}
		
		return vo;
	}
	
	// 스터디 조직을 개설할 때 데이터를 저장하는 메소드
	public int Study_Creation(String study_name, String study_begin, String study_end, String study_sub, String study_place, String study_week, String study_time, String study_onoff) {
		int cnt = 0;
		
		try {
			getConnection();
			
			// 스터디조직 개설 sql문
			String sql = "insert into Study values(Study_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			// SQL 실행 객체 생성
			psmt = conn.prepareStatement(sql);
			
			// 바인드 변수 채우기
			psmt.setString(1, study_name);
			psmt.setString(2, study_begin);
			psmt.setString(3, study_end);
			psmt.setString(4, study_sub);
			psmt.setString(5, study_place);
			psmt.setString(6, study_week);
			psmt.setString(7, study_time);
			psmt.setString(8, study_onoff);
			
			// sql문 실행 후 결과처리
			cnt = psmt.executeUpdate();
			
			if(cnt > 0) {
				System.out.println("스터디조직 개설 성공");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("스터디조직 개설 실패");
		} finally {
			close();
		}
		return cnt;
	}
	
	// 스터디 조직에 가입하는 메소드(작성중...Study와 StudyMember테이블의 중복된 부분 정리필요)
	public void Study_Join(int study_no, int member_no) {
		int cnt = 0;
		
		try {
			getConnection();
			
			// 스터디조직 가입 sql문(작성중...)
			String sql = "insert into StudyMember values(StudyMember_seq.nextval, ?, ?, ?, ?, ?, ?, ?)";
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("스터디 조직 가입 실패");
		} finally {
			close();
		}
	}
	
	// 스터디 조직 종료여부를 표시하는 메소드(delete)
	public int Study_End(int study_no) {
		//cnt변수 초기화
		int cnt = 0;
		
		try {
			getConnection();
			//스터디 없애는 sql문(delete)
			//Study테이블에서는 삭제, studyMember테이블에서는 삭제하지 않아도 될 듯함
			String sql = "delete from Study where study_no=?";
			
			//sql문 실행 객체 생성
			psmt= conn.prepareStatement(sql);
			
			//바인드변수-스터디순번
			psmt.setInt(1, study_no);
			
			//sql 실행 후 결과값
			cnt = psmt.executeUpdate();
			//삭제 성공 여부 출력
			if(cnt > 0) {
				System.out.println("스터디 조직 삭제 성공");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("스터디 조직 삭제 실패");
		}finally {
			close();
		}
		return cnt;
	}
	
	// 메인페이지에 4개정도의 스터디정보를 띄우는 메소드
	//리턴 타입은 ArrayList<StudyVO>->스터디 정보들 보관
	public ArrayList<StudyVO> Study_MainView() {
		ArrayList<StudyVO> list = new ArrayList<StudyVO>();
		try {
			getConnection();
			
			//스터디 시작일이 빠른 순서대로 4개를 출력하는 sql문
			//서브쿼리로 스터디시작일이 빠른 순서를 가져와서 4개만 출력
			String sql = "selete * from (selete * from Study order by study_begin asc) where rownum = 4";
			
			//sql문 실행 객체 생성
			psmt= conn.prepareStatement(sql);
			
			rs = psmt.executeQuery();
			
			//메인페이지에 띄울 스터디 정보 가져오기
			if(rs.next()) {
				System.out.println("메인페이지 스터디 조직 출력 성공");
				
				//스터디에 대한 모든 정보 가져옴
				//study_no은 안가져와도 될 것 같은데 의논필요
				int study_no = rs.getInt("study_no");
				String study_name = rs.getString("study_name");
				String study_begin = rs.getString("study_begin");
				String study_end = rs.getString("study_end");
				String study_sub = rs.getString("study_sub");
				String study_place = rs.getString("study_place");
				String study_week = rs.getString("study_week");
				String study_time = rs.getString("study_time");
				String study_onoff = rs.getString("study_onoff");
				
				StudyVO vo = new StudyVO(study_no, study_name, study_begin, study_end, study_sub, study_place, study_week, study_time, study_onoff);
				list.add(vo);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("메인페이지에 스터디 보이기 실패");
		}finally {
			close();
		}
		return list;
	}
}
