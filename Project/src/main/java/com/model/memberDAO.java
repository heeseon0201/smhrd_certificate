package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;
//DAO: Data Access Object
//DTO: Data Transfer Object
public class memberDAO {
	Connection conn = null;
	PreparedStatement pst=null;
	ResultSet rs = null;
	
	//db연결 메소드
	public void getConnection() {
		try {
			//1. JDBC 드라이버 동적 로딩
			//ClassNotFoundException 오류가 뜨는경우
			//해결방법1.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String password = "hr";
			//2. 데이터베이스 연결 객체(Connection) 생성
			conn = DriverManager.getConnection(url, user, password);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//db close 메소드
	public void close() {
		try {
			if(rs!=null) {
				rs.close();
			}
			if(pst!=null) {
				pst.close();
			}
			if(conn!=null) {
				conn.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//회원가입할때 호출할 메서드
	public int join(String id, String pw) {
		//다른클래스에서 메서드가 무언가를 알고있어야 한다면 매개변수로 넘겨주면 된다.
		
		//try~catch: 예외처리(db와 연결 sql 문은 런타임오류가 발생할 우려가 있기 때문에)
		int cnt = 0;
		try {
			getConnection();
			System.out.println("접속");
			
			//3. SQL 준비/실행 객체(PreparedStatement) 생성
			pst = conn.prepareStatement("insert into project_member values(?,?)");
			
			//4. 바인드 변수 채우기(바인드변수 순서는 1부터 시작, 채워줄 값)
			pst.setString(1, id);
			pst.setString(2, pw);
			System.out.println("변수넣음");

			
			//5. sql문 실행 후 결과처리
			//cnt: sql문 실행시 테이블상에 변화가 일어나는 레코드의 수
			cnt = pst.executeUpdate();
			
			if(cnt>0) {
				System.out.println("회원가입성공!");

			}
			
		}catch(Exception e){
			System.out.println("회원가입실패");
			e.printStackTrace();//예외상황 발생 순서대로 출력. 개발상황에서 쓰는 것을 추천
			
		}finally {
			close();
		}
		return cnt;
	}
	public memberVO login(String email, String pw) {

		//받아온 값이 테이블상에 존재하는지 확인(DB) JDBC
		memberVO vo = null;// 미리 선언한다
		try {
			getConnection();
			//3. SQL 준비/실행 객체(PreparedStatement) 생성
			String sql = "select * from web_member where email=? and pw=?";
			pst = conn.prepareStatement(sql);
			
			//4. 바인드 변수 채우기(바인드변수 순서는 1부터 시작, 채워줄 값)
			pst.setString(1, email);
			pst.setString(2, pw);
			
			//5. sql문 실행 
			rs = pst.executeQuery();
			
			//6.결과처리
			if(rs.next()) {
				System.out.println("로그인성공");
				String get_email = rs.getString(1);//rs.getString("email"); //인덱스번호 컬럼이름 둘다 상관없다.
				String get_tel = rs.getString("tel");
				String get_address = rs.getString("address");
				
				vo = new memberVO(get_email, get_tel, get_address);//객체로 묶어줌

			}
			
		}catch(Exception e){
			System.out.println("로그인실패");
			e.printStackTrace();
		}finally {
			
			close();
		}
		return vo;
	}
	//회원정보수정할 때 호출할 메소드
	public int update(String pw, String tel, String address, String email) {
		//현재 로그인한 회원(이메일 활용)의 pw, tel, address 수정
		//수정 성공시 console에 "회원정보수정 성공" 출력
		//(update는 java시간 작성한 update / messagesystem join(insert) 참고)
		
		int cnt=0;
		
		try {
			getConnection();
			
			//3. SQL 준비/실행 객체(PreparedStatement) 생성
			String sql="update web_member set pw=?, tel=?, address=? where email=?";
			pst = conn.prepareStatement(sql);
			
			//4. 바인드 변수 채우기(바인드변수 순서는 1부터 시작, 채워줄 값)
			pst.setString(1, pw); //updateService에서 잘라왔는데 변수정의가 안되어있다. 그래서 매개변수로 받아와주기 한다.
			pst.setString(2, tel);
			pst.setString(3, address);
			pst.setString(4, email);
			
			//5. sql문 실행 후 결과처리
			//cnt: sql문 실행시 테이블상에 변화가 일어나는 레코드의 수
			cnt = pst.executeUpdate();//몇개의 레코드가 반환되었는지 정수로 반환
			
			
			
		}catch(Exception e){
			System.out.println("수정실패");
			e.printStackTrace();//예외상황 발생 순서대로 출력. 개발상황에서 쓰는 것을 추천
			
		}finally {
			close();
		}
		return cnt;
	}
	
	//관리자 회원정보관리 메소드
	public ArrayList<memberVO> select() {
		ArrayList<memberVO> list = new ArrayList<memberVO>();
		try {
			getConnection();
			String sql = "select email, tel, address from web_member";
			
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				//회원 한명의 개별 값
				String email = rs.getString("email");
				String tel = rs.getString("tel");
				String address = rs.getString("address");
				
				//회원 한명의 값//파우치에 담기
				memberVO vo = new memberVO(email, tel, address);
				list.add(vo);//가장큰 가방에 담기
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}
}
