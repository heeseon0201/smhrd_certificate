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
			psmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			// sql문 실행
			rs = psmt.executeQuery();
			
			// 결과처리
			// while문에서 첫번째 데이터가 출력이 안되는 것을 확인해서 임시조치

				
			while(true) {
				if(rs.next()) {		
					int study_no = rs.getInt("study_no");
					System.out.println(study_no);
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
			psmt = conn.prepareStatement(sql1);
			
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
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("스터디조직 개설 실패");
		} finally {
			close();
		}
		return cnt;
	}

	public int StudyMember_Creation(int study_no, int member_no) {
		int cnt = 0;
		
		try {
			getConnection();
			
			// 스터디조직 개설 sql문
			String sql = "insert into studymember values(studyMember_seq.nextval, ?, ?)";
			
			// SQL 실행 객체 생성
			psmt = conn.prepareStatement(sql);
						
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
			System.out.println("스터디멤버 개설 실패");
		} finally {
			close();
		}
		return cnt;
	}
//	//스터디번호꺼내오기 메서드
//	int study_no= newStudyNo();			
	
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
//				String study_onoff = rs.getString("study_onoff");
				
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
	
	// 스터디를 검색해주는 메소드 
	public ArrayList<StudyVO> Study_Search(String words) {
		ArrayList<StudyVO> list = new ArrayList<StudyVO>();
		String sql = "";
		
		try {
			getConnection();
			
			// 공백으로 검색어를 구분
			String[] hitwords = words.split(" ");
			
			System.out.println(hitwords);
			for (int i= 0; i< hitwords.length ; i++){
				System.out.println(hitwords[i]);
			}
			
			for (int i=0; i<hitwords.length; i++) {
				// 검색 sql문
				sql = "select * from Study where study_name like '%" + hitwords[i] + "%' OR study_sub like '%" + hitwords[i] + "%' OR study_place like '%" + hitwords[i] + "%'";
				
				// SQL 실행 객체 생성
				psmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
				
				// sql문 실행
				rs = psmt.executeQuery();
				
				// 검색어가 안걸리는 경우 속도가 너무느려서 검색어가 잡히지 않을 경우 컨티뉴로 다음 iteration으로 넘기는 부분 추가
				if(!rs.next()) {
					continue;
				} else {
					int get_no = rs.getInt("study_no");
					String get_name = rs.getString("study_name");
					String get_begin = rs.getString("study_begin");
					String get_end = rs.getString("study_end");
					String get_sub = rs.getString("study_sub");
					String get_place = rs.getString("study_place");
					String get_week = rs.getString("study_week");
					String get_time = rs.getString("study_time");
					
					StudyVO vo = new StudyVO(get_no, get_name, get_begin, get_end, get_sub, get_place, get_week, get_time);
					list.add(vo);
				
					// 결과처리
					while(true) {
						if(rs.next()) {
							get_no = rs.getInt("study_no");
							get_name = rs.getString("study_name");
							get_begin = rs.getString("study_begin");
							get_end = rs.getString("study_end");
							get_sub = rs.getString("study_sub");
							get_place = rs.getString("study_place");
							get_week = rs.getString("study_week");
							get_time = rs.getString("study_time");
							
							vo = new StudyVO(get_no, get_name, get_begin, get_end, get_sub, get_place, get_week, get_time);
							list.add(vo);
						}
						
						if(rs.isLast()) {
							break;
						}
						
						if(!rs.next()) {
							break;
						}
					}
				}
			}
			System.out.println("스터디 검색 성공");
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("스터디 검색 실패");
		} finally {
			close();
		}
		return list;
	}
}
