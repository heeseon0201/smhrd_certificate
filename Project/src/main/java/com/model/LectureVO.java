package com.model;

public class LectureVO {
	// 필드생성
	private int lecture_no;	// 순번
	private String lecture_NM;	// 강의명
	private String lecture_teach; // 강사명
	private String lecture_site;	// 컨텐츠제공사이트
	private String lecture_count;	// 총 강의수
	private int lecture_price;		// 가격
	private int lecture_point;		// 평점
	private String lecture_review;	// 후기
	private String lecture_url;		// URL
	private String lecture_cat;		// 카테고리
	
	// 생성자
	public LectureVO(int lecture_no, String lecture_NM, String lecture_teach, String lecture_site, String lecture_count,
			int lecture_price, int lecture_point, String lecture_review, String lecture_url, String lecture_cat) {
		super();
		this.lecture_no = lecture_no;
		this.lecture_NM = lecture_NM;
		this.lecture_teach = lecture_teach;
		this.lecture_site = lecture_site;
		this.lecture_count = lecture_count;
		this.lecture_price = lecture_price;
		this.lecture_point = lecture_point;
		this.lecture_review = lecture_review;
		this.lecture_url = lecture_url;
		this.lecture_cat = lecture_cat;
	}
	
	// 메소드(get,set)
	public int getLecture_no() {
		return lecture_no;
	}

	public void setLecture_no(int lecture_no) {
		this.lecture_no = lecture_no;
	}

	public String getLecture_NM() {
		return lecture_NM;
	}

	public void setLecture_NM(String lecture_NM) {
		this.lecture_NM = lecture_NM;
	}

	public String getLecture_teach() {
		return lecture_teach;
	}

	public void setLecture_teach(String lecture_teach) {
		this.lecture_teach = lecture_teach;
	}

	public String getLecture_site() {
		return lecture_site;
	}

	public void setLecture_site(String lecture_site) {
		this.lecture_site = lecture_site;
	}

	public String getLecture_count() {
		return lecture_count;
	}

	public void setLecture_count(String lecture_count) {
		this.lecture_count = lecture_count;
	}

	public int getLecture_price() {
		return lecture_price;
	}

	public void setLecture_price(int lecture_price) {
		this.lecture_price = lecture_price;
	}

	public int getLecture_point() {
		return lecture_point;
	}

	public void setLecture_point(int lecture_point) {
		this.lecture_point = lecture_point;
	}

	public String getLecture_review() {
		return lecture_review;
	}

	public void setLecture_review(String lecture_review) {
		this.lecture_review = lecture_review;
	}

	public String getLecture_url() {
		return lecture_url;
	}

	public void setLecture_url(String lecture_url) {
		this.lecture_url = lecture_url;
	}

	public String getLecture_cat() {
		return lecture_cat;
	}

	public void setLecture_cat(String lecture_cat) {
		this.lecture_cat = lecture_cat;
	}
}
