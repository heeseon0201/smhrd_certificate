package com.model;

import java.util.ArrayList;

public class test {

	public static void main(String[] args) {
		// 시험용 코드 삭제예정
		
		// DAO의 Lecture_viewAll 실행해서 전체 테이블 데이터 가져오기
		LectureDAO dao = new LectureDAO();
		ArrayList<LectureVO> list = dao.Lecture_ViewAll();
		
		if(list.size()>0) {
			LectureVO vo = list.get(1);
			
			String a = vo.getLecture_name();
			
			System.out.println(a);
		} else {
			System.out.println("list에러");
		}

	}

}
