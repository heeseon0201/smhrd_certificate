package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class messageDAO {
	
	Connection conn = null;
	PreparedStatement pst=null;
	ResultSet rs = null;
	int cnt = 0;
	
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
		//메시지 보내기(DB저장하는)메소드
		public int insertMessage(messageVO vo) {
			getConnection();
			
			try {
				String sql="insert into web_message values(num_message.nextval, ?,?,?, sysdate)";
				pst = conn.prepareStatement(sql);
				pst.setString(1, vo.getSendEmail());
				pst.setString(2, vo.getReceiveEmail());
				pst.setString(3, vo.getMessage());
				
				cnt = pst.executeUpdate();
				
			}catch(Exception e){
				e.printStackTrace();
			}finally {
				close();
			}
			return cnt;
		}
		//나에게 온 메시지 확인하는 메소드
		public ArrayList<messageVO> showMessage(String email) {
			ArrayList<messageVO> message_list = new ArrayList<messageVO>();
			getConnection();
			try {
				String sql = "select * from web_message where receiveEmail=?";
				pst = conn.prepareStatement(sql);
				pst.setString(1,email);
				rs = pst.executeQuery();
				
				while(rs.next()) {
					int num = rs.getInt("num");
					String sendEmail = rs.getString("sendEmail");
					String receiveEmail = rs.getString("receiveEmail");
					String message = rs.getString("message");
					String m_day = rs.getString("m_day");
					
					messageVO vo = new messageVO(num, sendEmail, receiveEmail, message, m_day);
					message_list.add(vo);
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}finally {
				close();
			}return message_list;
		}
		
		public int DeleteService(String email) {
			getConnection();
			try {
				String sql = "delete from web_message where receiveEmail=?";
				pst = conn.prepareStatement(sql);
				pst.setString(1, email);
				cnt = pst.executeUpdate();
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				close();
			}return cnt;
		}
		//메시지 하나 삭제 메소드
		public int deleteOne(String num) {
			getConnection();
			try {
				String sql = "delete from web_message where num = ?";
				pst = conn.prepareStatement(sql);
				pst.setString(1, num);
				cnt = pst.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				close();
			}return cnt;
		}
}
