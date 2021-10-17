package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
	public int Course_Insert(int member_no, int lecture_no) {
		int cnt = 0;
		
		try {
			getConnection();
			
			// 인강 선택후 각 변수처리 정리:
			// member_no, lecture_no는 매개변수로 받음
			// 수강번호는 시퀸스로 SQL developer에서 받음
			// 수강시작시간은 선택한 시간으로 저장
			// 수료여부는 선택시 N으로 저장하고 후에 Y로 바꿀수있게
			
			// 회원이 수강을 선택하면 선택해제할 때까지 이 기능을 작동시키지 못하게 해야함.
			
			// 수강선택시 데이터저장 sql문
			String sql = "insert into COURSE values(COURSE_SEQ.nextval, ?, ?, TO_CHAR(SYSDATE, 'YYYY-MM-DD'), 'N')";
//			String sql = "select member_no from member where member_id=?";
			
			// SQL 실행 객체 생성
			psmt = conn.prepareStatement(sql);
			
			// 바인드 변수 채우기
			psmt.setInt(1, member_no);
			psmt.setInt(2, lecture_no);
			
			// sql문 실행 후 결과처리
			cnt = psmt.executeUpdate();
			
			if(cnt > 0) {
				System.out.println("강의 선택성공");
			}
			
			
//			///====================================여기부터 기록 필요================================
//			//개인적 생각으로는 회원번호와 인강순번만 기록하는게 베스트
//			//테이블 수정필요
//			//마지막에 SEQUENCE넣어야
//			//수료여부: NO
//			//String sql2 = "insert into course values(?, ?, sysdate, ?, )";
//			
//			psmt.setString(1, member_no); //회원번호 삽입
//			psmt.setInt(2, lecture_no); //인강순번
//									//수강시작일자 sysdate
//			
//			// sql문 실행 후 결과처리
//			cnt = psmt.executeUpdate();
//						
//			if(cnt > 0) {
//				System.out.println("강의선택 성공");
//			}
						
		} catch(Exception e) {
			System.out.println("강의선택 실패");
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}
	
	// 선택한 수강정보를 가져오는 메소드
	public CourseVO Course_Select(int member_no, int lecture_no) {
		CourseVO vo = null;
		
		try {
			getConnection();
			
			// 수강정보 가져오는 sql문
			String sql = "select * from COURSE where member_no_co = ? and lecture_no_co = ?";
			
			// SQL 실행 객체 생성
			psmt = conn.prepareStatement(sql);
			
			// 바인드 변수 채우기
			psmt.setInt(1, member_no);
			psmt.setInt(2, lecture_no);
			
			// sql문 실행
			rs = psmt.executeQuery();
			
			// 결과처리
			if(rs.next()) {		
				System.out.println("강의데이터 가져오기 성공");
				
				int get_member_no_co = rs.getInt("member_no_co");
				int get_lecture_no_co = rs.getInt("lecture_no_co");
				String get_course_sd = rs.getString("course_sd");
				String get_course_comp = rs.getString("course_comp");
				int get_course_no = rs.getInt("course_no");
				
				vo = new CourseVO(get_member_no_co, get_lecture_no_co, get_course_sd, get_course_comp, get_course_no);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("강의데이터 가져오기 실패");
		} finally {
			close();
		}
		return vo;
	}
	
	// 수강번호를 참조하여 수강정보를 가져오는 메소드
	public CourseVO Course_SelectByCourse(int course_no) {
		CourseVO vo = null;
		
		try {
			getConnection();
			
			// 수강정보 가져오는 sql문
			String sql = "select * from COURSE where course_no = ?";
			
			// SQL 실행 객체 생성
			psmt = conn.prepareStatement(sql);
			
			// 바인드 변수 채우기
			psmt.setInt(1, course_no);
			
			// sql문 실행
			rs = psmt.executeQuery();
			
			// 결과처리
			if(rs.next()) {		
				System.out.println("강의데이터 가져오기 성공");
				
				int get_member_no_co = rs.getInt("member_no_co");
				int get_lecture_no_co = rs.getInt("lecture_no_co");
				String get_course_sd = rs.getString("course_sd");
				String get_course_comp = rs.getString("course_comp");
				int get_course_no = rs.getInt("course_no");
				
				vo = new CourseVO(get_member_no_co, get_lecture_no_co, get_course_sd, get_course_comp, get_course_no);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("강의데이터 가져오기 실패");
		} finally {
			close();
		}
		return vo;
	}
	
	// 수강완료 표시 메소드
	public int Course_Complete(int course_no) {
		int cnt = 0;
		
		try {
			getConnection();
			
			// 수료완료정보 수정 sql문
			String sql = "update COURSE set course_onoff = 'Y' where course_no = ?";
			
			// SQL 실행 객체 생성
			psmt = conn.prepareStatement(sql);
			
			// 바인드 변수 채우기
			psmt.setInt(1, course_no);
			
			// sql문 실행 후 결과처리
			cnt = psmt.executeUpdate();
			
			if(cnt > 0) {
				System.out.println("회원정보 수정 성공");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("수료여부 갱신 실패");
		} finally {
			close();
		}
		return cnt;
	}
	public ArrayList<LectureVO> Course_mypage(int member_no) {
		ArrayList<LectureVO> list = new ArrayList<LectureVO>();
		try {
			getConnection();
			
			// 수강정보 가져오는 sql문
			String sql = "select * from COURSE join lecture on lecture_no = lecture_no_co where member_no_co = ?";
			
			// SQL 실행 객체 생성
			psmt = conn.prepareStatement(sql);
			
			// 바인드 변수 채우기
			psmt.setInt(1, member_no);
			
			// sql문 실행
			rs = psmt.executeQuery();
			
			// 결과처리
			if(rs.next()) {		
				System.out.println("마이페이지 강의데이터 가져오기 성공");
				
				// 결과처리
				while(true) {
					if(rs.next()) {		
						int get_no = rs.getInt("lecture_no");
						String get_cat = rs.getString("lecture_cat");
						String get_name = rs.getString("lecture_name");		
						String get_teach = rs.getString("lecture_teach");
						String get_count = rs.getString("lecture_count");
						int get_price = rs.getInt("lecture_price");
						double get_point = rs.getDouble("lecture_point");
						String get_review = rs.getString("lecture_review");
						String get_url = rs.getString("lecture_url");

						LectureVO vo = new LectureVO(get_no, get_name, get_teach, get_count, get_price, get_point, get_review, get_url, get_cat);
						list.add(vo);
					}
					
					if(rs.isLast()) {
						break;
					}
				}
				
				
			}
			}catch (Exception e) {
			e.printStackTrace();
			System.out.println("마이페이지 강의데이터 가져오기 실패");
		}finally {
			close();
		}
		return list;
	}
}
