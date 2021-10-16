package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class LectureDAO {
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
	
	// 강의정보 전체 데이터를 보여주는 메소드
	public ArrayList<LectureVO> Lecture_ViewAll() {
		ArrayList<LectureVO> list = new ArrayList<LectureVO>();
		
		try {
			getConnection();
			
			// 강의정보 전체출력 sql문
			String sql = "select * from Lecture";
			
			// SQL 실행 객체생성
			psmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			// sql문 실행
			rs = psmt.executeQuery();
			
			// 결과처리
			while(true) {
				if(rs.next()) {		
					int get_no = rs.getInt("lecture_no");
					String get_name = rs.getString("lecture_name");
					String get_teach = rs.getString("lecture_teach");
					String get_count = rs.getString("lecture_count");
					int get_price = rs.getInt("lecture_price");
					double get_point = rs.getDouble("lecture_point");
					String get_review = rs.getString("lecture_review");
					String get_url = rs.getString("lecture_url");
					String get_cat = rs.getString("lecture_cat");
					
					LectureVO vo = new LectureVO(get_no, get_name, get_teach, get_count, get_price, get_point, get_review, get_url, get_cat);
					list.add(vo);
				}
				
				if(rs.isLast()) {
					break;
				}
			}
			System.out.println("강의정보 출력 성공");

			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("강의정보 출력 실패");
		} finally {
			close();
		}
		return list;
	}

	// 검색 메소드
	public ArrayList<LectureVO> Lecture_Search(String words){
		ArrayList<LectureVO> list = new ArrayList<LectureVO>();
		String sql = "";
		
		try {
			getConnection();
			
			// 공백으로 검색어를 구분
			String[] hitwords = words.split(" ");

			for (int i=0; i<hitwords.length; i++) {
				
				// 검색 sql문
//				sql = "select * from Lecture where lecture_name like '%" + hitwords[i] + "%'";//푸시
				// 리뷰데이터가 너무길어서 검색이 작동안함
//				sql = "select * from Lecture where lecture_name like '%" + hitwords[i] + "%' OR lecture_teach like '%" + hitwords[i] + "%' OR lecture_count like '%" + hitwords[i] + "%' OR lecture_review like '%" + hitwords[i] + "%' OR lecture_cat like '%" + hitwords[i] + "%'";
				// 리뷰검색을 뺀 코드사용
				sql = "select * from Lecture where lecture_name like '%" + hitwords[i] + "%' OR lecture_teach like '%" + hitwords[i] + "%' OR lecture_cat like '%" + hitwords[i] + "%'";

				// 현재 강의명에 걸린 하이퍼링크까지 검색되어버림 
				// 만약 lecture_name에 "https://"가 있으면 그 뒤 내용을 지워서 저장한다.(X 이 방법은 틀린듯)
				
				// SQL 실행 객체 생성
				psmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

				// sql문 실행
				rs = psmt.executeQuery();
				
				// 검색어가 안걸리는 경우 속도가 너무느려서 검색어가 잡히지 않을 경우 컨티뉴로 다음 iteration으로 넘기는 부분 추가
				if(!rs.next()) {
					continue;
				}
				
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
			System.out.println("검색 성공");
					
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("검색 실패");
		} finally {
			close();
		}
		
		return list;
	}

	// 필터 메소드
	public ArrayList<LectureVO> Lecture_filter(ArrayList<String> filter){
		ArrayList<LectureVO> list = new ArrayList<LectureVO>();
		String sql = "";
		
		try {
			getConnection();
			
			for(int i=0; i<filter.size();i++) {
				// 필터 sql문(반복문을 돌려 선택한 필터에 대한 내용들만 가져오기)
				sql = "select * from Lecture where lecture_cat = ?";
				
				// SQL 실행 객체 생성
				psmt = conn.prepareStatement(sql);
				
				// 바인드 변수 채우기
				psmt.setString(1, filter.get(i));
				
				// sql문 실행
				rs = psmt.executeQuery();
				
				// 결과처리
				if(rs.next()) {		
					int get_no = rs.getInt("lecture_no");
					String get_name = rs.getString("lecture_name");
					String get_teach = rs.getString("lecture_teach");
					String get_count = rs.getString("lecture_count");
					int get_price = rs.getInt("lecture_price");
					double get_point = rs.getDouble("lecture_point");
					String get_review = rs.getString("lecture_review");
					String get_url = rs.getString("lecture_url");
					String get_cat = rs.getString("lecture_cat");
					
					LectureVO vo = new LectureVO(get_no, get_name, get_teach, get_count, get_price, get_point, get_review, get_url, get_cat);
					list.add(vo);
				}
			}
			System.out.println("필터 검색 성공");
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("필터 검색 실패");
		} finally {
			close();
		}
		return list;
	}
	
	// 메인페이지에 4개정도의 강의정보를 띄우는 메소드(강의명, 강사명, 평점, 카테고리)
	public ArrayList<LectureVO> Lecture_MainView() {
		ArrayList<LectureVO> list = new ArrayList<LectureVO>();
		
		try {
			getConnection();
			
			// 강의정보의 일부칼럼만 출력하는 sql문(상위 4개를 뽑아내는 작업은 controller의 Lecture_MainViewService에서 수행)
			String sql = "select lecture_name, lecture_teach, lecture_point, lecture_cat from Lecture order by lecture_point desc";
			
			// SQL 실행 객체생성
			psmt = conn.prepareStatement(sql);
			
			// sql문 실행
			rs = psmt.executeQuery();
			
			// 결과처리
			if(rs.next()) {		
				System.out.println("강의정보 메인창 띄우기 성공");
				
				String lecture_name = rs.getString("lecture_name");
				String lecture_teach = rs.getString("lecture_teach");
				int lecture_point = rs.getInt("lecture_point");
				String lecture_cat = rs.getString("lecture_cat");

				
				LectureVO vo = new LectureVO(lecture_name, lecture_teach, lecture_point, lecture_cat);
				list.add(vo);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("강의정보 메인창 띄우기 실패");
		} finally {
			close();
		}
		return list;
	}

	// 선택한 강의의 리뷰를 보여주는 기능
	public String[] Lecture_SelectReview(int lecture_no){
		String get_review = null;
		String[] reviewlist = null;
		
		try {
			getConnection();
			
			// 선택한 강의의 리뷰를 출력하는 sql문
			String sql = "select lecture_review from Lecture where lecture_no = ?";
			
			// SQL 실행 객체생성
			psmt = conn.prepareStatement(sql);
			
			// 바인드 변수 채우기
			psmt.setInt(1, lecture_no);
			
			// sql문 실행
			rs = psmt.executeQuery();
			
			// 결과처리
			if(rs.next()) {		
				// 전처리된 리뷰 통째로 들고오기
				get_review = rs.getString("lecture_review");
				
				// 구분자에 따라 리뷰를 쪼개서 저장
				reviewlist = get_review.split("DELIMITER111 ");
			}
			
			System.out.println("리뷰표시 성공");
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("리뷰표시 실패");
		} finally {
			close();
		}
		return reviewlist;
	}
	
	//마이페이지에서 강의정보를 보여주는 메소드
		//public void Lecture_SelectMy(i){
		//}
	//강의를 선택하면, COURSE테이블에 자동으로 쌓이게 하는 메소드
		//public void Lecture_Select() {
			
		//}
}

