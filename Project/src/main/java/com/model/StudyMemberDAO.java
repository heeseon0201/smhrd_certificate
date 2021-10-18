package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
	//가입한 스터디조직을 보여주는 메소드(마이페이지)
	public ArrayList<StudyVO> StudyMember_Select(int member_no) {
		ArrayList<StudyVO> list = new ArrayList<StudyVO>();
		try {
			getConnection();
			String sql = "select * from Study S join StudyMember SM on S.study_no = SM.study_no_sm where SM.member_no_sm = ?";
			
			// SQL 실행 객체 생성
			psmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			// 바인드 변수 채우기
			psmt.setInt(1, member_no);
			
			// sql문 실행
			rs = psmt.executeQuery();
			
			// 결과처리
			// 스터디 테이블에 null값으로 이루어진 행이있어 렉걸림.
			
			
			while(true) {
				if(rs.next()) {	
					System.out.println("스터디 출력 성공");
					int study_no = rs.getInt("study_no");
					String study_name = rs.getString("study_name");
					String study_begin =  rs.getString("study_begin");
					String study_end =  rs.getString("study_end");
					String study_sub =  rs.getString("study_sub");
					String study_place =  rs.getString("study_place");
					String study_week =  rs.getString("study_week");
					String study_time =  rs.getString("study_time");
					
					StudyVO vo = new StudyVO(study_no, study_name, study_begin, study_end, study_sub, study_place, study_week, study_time);
					list.add(vo);
				}
				
				if(rs.isLast()) {
					break;
				}
				}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("스터디 출력 실패");
		}finally {
			close();
		}
		return list;
	
	}

	
		//스터디에 가입하는 메소드
		public int study_Join(String studyNo, int memberNo) {
			int cnt=0;
			try {
				getConnection();
				String sql = "insert into sutdymember values(StudyMember_seq.nextval, ?, ?);";
				psmt.setString(1, studyNo);
				psmt.setInt(2, memberNo);
				cnt = psmt.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("스터디 조직 가입 실패");
			}finally {
				close();
			}
			return cnt;
		}

		public int Study_MypageView(int member_no) {
			int cnt = 0;
			
			try {
				getConnection();
				
				
				
			} catch(Exception e) {
				e.printStackTrace();
				System.out.println("스터디 조직 가입 실패");
			} finally {
				close();
			}
			return cnt;
		}

}
