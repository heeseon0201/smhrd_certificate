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
					
					StudyVO vo = new StudyVO(study_no, study_name, study_begin, study_end, study_sub, study_place, study_week, study_time);
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
				
				vo = new StudyVO(study_no, study_name, study_begin, study_end, study_sub, study_place, study_week, study_time);
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
	public int Study_Creation(String study_name, String study_begin, String study_end, String study_sub, String study_place, String study_week, String study_time, int member_no) {
		int cnt = 0;
		
		try {
			getConnection();
			
			// 스터디조직 개설 sql문
			String sql1 = "insert into study values(study_seq.nextval, ?, ?, ?, ?, ?, ?, ?)";
			
			// SQL 실행 객체 생성
			psmt = conn.prepareStatement(sql1, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			// 바인드 변수 채우기
			psmt.setString(1, study_name);
			psmt.setString(2, study_begin);
			psmt.setString(3, study_end);
			psmt.setString(4, study_sub);
			psmt.setString(5, study_place);
			psmt.setString(6, study_week);
			psmt.setString(7, study_time);
			
			// sql문 실행 후 결과처리
			cnt = psmt.executeUpdate();
			
			if(cnt > 0) {
				System.out.println("스터디테이블 개설 성공");
			}
			
			//스터디번호꺼내오기 메서드
			int study_no= newStudyNo();
							
			// 스터디조직 개설 sql문
			String sql = "insert into studymember values(studyMember_seq.nextval, ?, ?)";
						
			// SQL 실행 객체 생성
			psmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
						
			// 바인드 변수 채우기
			psmt.setInt(1, study_no);
			psmt.setInt(2, member_no);
					
			// sql문 실행 후 결과처리
			cnt = psmt.executeUpdate();
						
			if(cnt > 0) {
			System.out.println("스터디멤버 개설 성공");
			}
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("스터디조직 개설 실패");
		} finally {
			close();
		}
		return cnt;
	}
	//방금 만든 스터디의 넘버를 받아오는 메서드
		public int newStudyNo() {
			int study_no = 0;
			
			try {
				getConnection();
				
				// 스터디정보 선택출력 sql문
				String sql = "select study_no from (select study_no from study order by study_no desc) where rownum =1";
				//study 컬럼을 스터디 넘버기준으로 오름차순 정렬한 다음 가장 마지막 번호를 가져오는 sql문입니다.
				
				// sql문 실행
				rs = psmt.executeQuery();
				
				// 결과처리
				if(rs.next()) {		
					System.out.println("스터디번호 출력 성공");
					study_no = Integer.parseInt(rs.getString("study_no"));
				}
				
			} catch(Exception e) {
				e.printStackTrace();
				System.out.println("스터디번호 출력 실패");
			} finally {
				close();
			}
			
			return study_no;
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
				
				StudyVO vo = new StudyVO(study_no, study_name, study_begin, study_end, study_sub, study_place, study_week, study_time);
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
	//
}
